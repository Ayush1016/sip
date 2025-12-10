package com.example.stock_sip_api.controller;

import com.example.stock_sip_api.dto.FundInsightDto;
import com.example.stock_sip_api.dto.LiveMutualFundDto;
import com.example.stock_sip_api.dto.MutualFundSuggestion;
import com.example.stock_sip_api.service.MutualFundLiveService;
import com.example.stock_sip_api.service.MutualFundService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mutual-funds")
public class MutualFundApiController {

    private final MutualFundService mutualFundService;
    private final MutualFundLiveService mutualFundLiveService;

    public MutualFundApiController(MutualFundService mutualFundService,
                                   MutualFundLiveService mutualFundLiveService) {
        this.mutualFundService = mutualFundService;
        this.mutualFundLiveService = mutualFundLiveService;
    }

    // ---------- STATIC / SUGGESTED FUNDS (Portfolio + Planner dropdown) ----------

    @GetMapping("/suggestions")
    public List<MutualFundSuggestion> suggestions() {
        return mutualFundService.getSuggestedFunds();
    }

    // ---------- LIVE SEARCH (MFAPI) ----------

    @GetMapping("/live/search")
    public List<LiveMutualFundDto> liveSearch(@RequestParam("q") String query) {
        return mutualFundLiveService.searchFunds(query);
    }

    // ---------- FUND INSIGHT (detailed view for 1 MF) ----------

    @GetMapping("/insight")
    public FundInsightDto insight(@RequestParam("code") String schemeCode,
                                  @RequestParam("name") String schemeName) {
        return mutualFundLiveService.getInsight(schemeCode, schemeName);
    }
}
