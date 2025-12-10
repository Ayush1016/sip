package com.example.stock_sip_api.service;

import com.example.stock_sip_api.dto.MfSearchResult;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MutualFundApiService {

    private static final String BASE_URL = "https://api.mfapi.in";

    private final RestTemplate restTemplate;

    public MutualFundApiService(RestTemplateBuilder builder) {
        this.restTemplate = builder
                .setConnectTimeout(Duration.ofSeconds(3))
                .setReadTimeout(Duration.ofSeconds(5))
                .build();
    }

    /**
     * Calls real MFAPI.in search endpoint:
     * GET https://api.mfapi.in/mf/search?q=<query>
     */
    public List<MfSearchResult> search(String query) {
        if (query == null || query.isBlank()) {
            return Collections.emptyList();
        }

        String url = BASE_URL + "/mf/search?q={q}";

        MfSearchResult[] body = restTemplate
                .getForObject(url, MfSearchResult[].class, query.trim());

        if (body == null) {
            return Collections.emptyList();
        }

        return Arrays.asList(body);
    }
}
