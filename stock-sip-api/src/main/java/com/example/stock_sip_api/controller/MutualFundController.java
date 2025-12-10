//package com.example.stock_sip_api.controller;
//
//import com.example.stock_sip_api.dto.MutualFundSuggestion;
//import com.example.stock_sip_api.service.MutualFundService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/mutual-funds")
//public class MutualFundController {
//
//    private final MutualFundService mutualFundService;
//
//    public MutualFundController(MutualFundService mutualFundService) {
//        this.mutualFundService = mutualFundService;
//    }
//
//    // Local curated list (no real API)
//    @GetMapping("/suggestions")
//    public List<MutualFundSuggestion> getSuggestedFunds() {
//        return mutualFundService.getSuggestedFunds();
//    }
//
//    // IMPORTANT: do NOT add /search here,
//    // that path is now handled by MutualFundApiController
//}
