package com.example.stock_sip_api.service;
import com.example.stock_sip_api.dto.FundInsightDto;

import com.example.stock_sip_api.dto.LiveMutualFundDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;



@Service
public class MutualFundLiveService {

    private static final String BASE_URL = "https://api.mfapi.in/mf";
    private static final DateTimeFormatter NAV_DATE_FMT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private final RestTemplate restTemplate;

    public MutualFundLiveService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Search mutual funds using MFAPI.in and enrich with approx 1Y return% when possible.
     */
    public List<LiveMutualFundDto> searchFunds(String query) {
        if (query == null || query.isBlank()) {
            return List.of();
        }

        String url = BASE_URL + "/search?q={query}";
        MfSearchResult[] raw;
        try {
            raw = restTemplate.getForObject(url, MfSearchResult[].class, query);
        } catch (Exception ex) {
            ex.printStackTrace();
            return List.of();
        }

        if (raw == null || raw.length == 0) {
            return List.of();
        }

        // Limit to top few results to avoid too many detail calls
        return Arrays.stream(raw)
                .limit(10)
                .map(this::mapWithReturnPercent)
                .collect(Collectors.toList());
    }

    private LiveMutualFundDto mapWithReturnPercent(MfSearchResult searchResult) {
        if (searchResult == null || searchResult.schemeCode == null) {
            return new LiveMutualFundDto();
        }

        // Fetch scheme details (NAV history etc.)
        String detailUrl = BASE_URL + "/{code}";
        MfSchemeDetails details;
        try {
            details = restTemplate.getForObject(detailUrl, MfSchemeDetails.class, searchResult.schemeCode);
        } catch (Exception ex) {
            // In case detail API fails, still return basic info
            ex.printStackTrace();
            return new LiveMutualFundDto(
                    searchResult.schemeCode,
                    searchResult.schemeName,
                    null,
                    null,
                    null,
                    null,
                    null
            );
        }

        Double yearlyReturn = computeOneYearReturn(details);

        String fundHouse = (details != null && details.meta != null) ? details.meta.fundHouse : null;
        String category = (details != null && details.meta != null) ? details.meta.schemeCategory : null;

        return new LiveMutualFundDto(
                searchResult.schemeCode,
                searchResult.schemeName,
                fundHouse,
                category,
                null,           // riskLevel – you can derive from category if you want
                yearlyReturn,   // real approx return %
                null            // typicalReturnPercent (unused here – used by your static suggestions)
        );
    }

    /**
     * Approx simple 1-year return from NAV data.
     * If we don't find ~1 year gap, returns null.
     */
    private Double computeOneYearReturn(MfSchemeDetails details) {
        if (details == null || details.data == null || details.data.isEmpty()) {
            return null;
        }

        // Data from MFAPI is usually in reverse chronological order (latest first).
        List<MfNavEntry> navs = details.data;

        MfNavEntry latest = navs.get(0);
        LocalDate latestDate;
        double latestNav;
        try {
            latestDate = LocalDate.parse(latest.date, NAV_DATE_FMT);
            latestNav = Double.parseDouble(latest.nav);
        } catch (Exception ex) {
            return null;
        }

        // Find a NAV roughly 1 year before latest
        MfNavEntry oneYearAgoEntry = null;
        for (MfNavEntry entry : navs) {
            try {
                LocalDate d = LocalDate.parse(entry.date, NAV_DATE_FMT);
                long days = ChronoUnit.DAYS.between(d, latestDate);
                if (days >= 360 && days <= 370) {
                    oneYearAgoEntry = entry;
                    break;
                }
            } catch (Exception ignore) {
            }
        }

        if (oneYearAgoEntry == null) {
            // Fallback: try last entry if dataset is ~1 year deep
            MfNavEntry last = navs.get(navs.size() - 1);
            try {
                LocalDate d = LocalDate.parse(last.date, NAV_DATE_FMT);
                long days = ChronoUnit.DAYS.between(d, latestDate);
                if (days > 300) {
                    oneYearAgoEntry = last;
                }
            } catch (Exception ignore) {
            }
        }

        if (oneYearAgoEntry == null) {
            return null;
        }

        try {
            double navOld = Double.parseDouble(oneYearAgoEntry.nav);
            if (navOld <= 0) return null;

            double simpleReturn = (latestNav - navOld) / navOld * 100.0;
            return Math.round(simpleReturn * 100.0) / 100.0;  // round to 2 decimals
        } catch (Exception ex) {
            return null;
        }
    }

    /* ===========================
       INNER CLASSES for MFAPI JSON
       =========================== */

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MfSearchResult {
        @JsonProperty("schemeCode")
        public String schemeCode;

        @JsonProperty("schemeName")
        public String schemeName;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MfSchemeDetails {
        @JsonProperty("schemeCode")
        public String schemeCode;

        @JsonProperty("schemeName")
        public String schemeName;

        @JsonProperty("meta")
        public MfMeta meta;

        @JsonProperty("data")
        public List<MfNavEntry> data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MfMeta {
        @JsonProperty("fund_house")
        public String fundHouse;

        @JsonProperty("scheme_category")
        public String schemeCategory;

        @JsonProperty("scheme_type")
        public String schemeType;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MfNavEntry {
        @JsonProperty("date")
        public String date;  // "dd-MM-yyyy"

        @JsonProperty("nav")
        public String nav;
    }
    public FundInsightDto getInsight(String schemeCode, String schemeNameFromClient) {

        FundInsightDto dto = new FundInsightDto();
        dto.setSchemeCode(schemeCode);
        dto.setSchemeName(schemeNameFromClient);

        // TODO: Later you can fill these from a real API
        dto.setFundHouse("Unknown AMC");
        dto.setCategory("Equity - Large Cap");
        dto.setRiskLevel("High");
        dto.setExpenseRatio(0.90); // just example

        // Dummy returns so UI works – replace with real values later
        dto.setReturn1M(2.10);
        dto.setReturn6M(8.40);
        dto.setReturn1Y(14.70);
        dto.setReturn3Y(16.20);
        dto.setReturn5Y(17.80);
        dto.setReturn10Y(15.50);

        dto.setStyleTag("Aggressive long-term growth");
        dto.setSummary(
                "This fund has shown stronger performance over longer periods " +
                        "compared to short term. It is more suitable for investors " +
                        "who can stay invested for 7+ years and handle volatility."
        );

        return dto;
    }
}
