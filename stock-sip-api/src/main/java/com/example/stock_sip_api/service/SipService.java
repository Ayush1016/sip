package com.example.stock_sip_api.service;

import com.example.stock_sip_api.dto.SipRequest;
import com.example.stock_sip_api.dto.SipResponse;
import com.example.stock_sip_api.dto.YearlyProjection;
import com.example.stock_sip_api.dto.GoalResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SipService {

    // --------- 1) NORMAL SIP CALCULATOR (WHAT YOU ALREADY HAD) ---------
    public SipResponse calculateSip(SipRequest request) {

        double periodicInvestment = request.getMonthlyInvestment();
        int years = request.getTenureYears();
        double annualRate = request.getAnnualReturnRate();
        double lumpSum = request.getLumpSumInvestment();
        double inflationRate = request.getInflationRate();
        String frequency = request.getFrequency();

        if (frequency == null || frequency.isBlank()) {
            frequency = "MONTHLY";
        }

        int periodsPerYear = "WEEKLY".equalsIgnoreCase(frequency) ? 52 : 12;
        int totalPeriods = years * periodsPerYear;
        double periodRate = annualRate / periodsPerYear / 100.0;

        double totalInvested = lumpSum;
        double futureValue = lumpSum;

        List<YearlyProjection> projections = new ArrayList<>();

        for (int p = 1; p <= totalPeriods; p++) {
            totalInvested += periodicInvestment;
            futureValue = (futureValue + periodicInvestment) * (1 + periodRate);

            // Capture value at the end of each year
            if (p % periodsPerYear == 0 || p == totalPeriods) {
                int yearNumber = (int) Math.round((double) p / periodsPerYear);
                YearlyProjection yp = new YearlyProjection(
                        yearNumber,
                        totalInvested,
                        futureValue
                );
                projections.add(yp);
            }
        }

        // Inflation-adjusted future value
        double realFutureValue = futureValue;
        if (inflationRate > 0) {
            realFutureValue = futureValue /
                    Math.pow(1 + inflationRate / 100.0, years);
        }

        SipResponse response = new SipResponse();
        response.setTotalInvested(totalInvested);
        response.setFutureValue(futureValue);
        response.setProfit(futureValue - totalInvested);

        response.setRealFutureValue(realFutureValue);
        response.setRealProfit(realFutureValue - totalInvested);
        response.setProjections(projections);

        return response;
    }

    // --------- 2) GOAL CALCULATOR (TARGET → REQUIRED SIP) ---------
    public GoalResponse calculateGoal(double targetAmount, int years, double annualReturnRate) {

        double r = annualReturnRate / 100.0 / 12.0; // monthly rate
        int n = years * 12;                         // months

        // Future Value of SIP:
        // FV = SIP * [((1+r)^n - 1) / r] * (1+r)
        // So SIP = FV / ([((1+r)^n - 1) / r] * (1+r))

        double multiplier = ((Math.pow(1 + r, n) - 1) / r) * (1 + r);

        double requiredSip = targetAmount / multiplier;

        double totalInvested = requiredSip * n;
        double profit = targetAmount - totalInvested;

        return new GoalResponse(requiredSip, totalInvested, profit);
    }
}
