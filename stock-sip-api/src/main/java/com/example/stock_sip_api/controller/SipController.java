package com.example.stock_sip_api.controller;

import com.example.stock_sip_api.dto.SipRequest;
import com.example.stock_sip_api.dto.SipResponse;
import com.example.stock_sip_api.dto.GoalRequest;
import com.example.stock_sip_api.dto.GoalResponse;
import com.example.stock_sip_api.service.SipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sip")
public class SipController {

    @Autowired
    private SipService sipService;

    // ---------------------------------------------
    // 1) Normal SIP Calculator
    // ---------------------------------------------
    @PostMapping("/calculate")
    public SipResponse calculate(@RequestBody SipRequest request) {
        return sipService.calculateSip(request);
    }

    // ---------------------------------------------
    // 2) Goal SIP Calculator
    // ---------------------------------------------
    @PostMapping("/goal")
    public GoalResponse calculateGoal(@RequestBody GoalRequest request) {
        return sipService.calculateGoal(
                request.getTargetAmount(),
                request.getTenureYears(),
                request.getAnnualReturnRate()
        );
    }
}
