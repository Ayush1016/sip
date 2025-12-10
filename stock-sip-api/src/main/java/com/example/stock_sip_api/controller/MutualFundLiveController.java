//package com.example.stock_sip_api.controller;
//
//import com.example.stock_sip_api.dto.LiveMutualFundDto;
//import com.example.stock_sip_api.service.MutualFundLiveService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/mutual-funds/live")
//@CrossOrigin(origins = "http://localhost:8080") // adjust if frontend runs elsewhere
//public class MutualFundLiveController {
//
//    private final MutualFundLiveService mutualFundLiveService;
//
//    public MutualFundLiveController(MutualFundLiveService mutualFundLiveService) {
//        this.mutualFundLiveService = mutualFundLiveService;
//    }
//
//    /**
//     * Example: GET /api/mutual-funds/live/search?q=sbi
//     * Returns list with real approx returnPercent when available.
//     */
//    @GetMapping("/search")
//    public List<LiveMutualFundDto> search(@RequestParam("q") String query) {
//        return mutualFundLiveService.searchFunds(query);
//    }
//}
