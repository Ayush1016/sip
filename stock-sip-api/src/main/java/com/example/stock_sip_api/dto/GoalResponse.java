package com.example.stock_sip_api.dto;

public class GoalResponse {
    private double requiredMonthlySip;
    private double totalInvested;
    private double profit;

    public GoalResponse(double requiredMonthlySip, double totalInvested, double profit) {
        this.requiredMonthlySip = requiredMonthlySip;
        this.totalInvested = totalInvested;
        this.profit = profit;
    }

    public double getRequiredMonthlySip() {
        return requiredMonthlySip;
    }

    public double getTotalInvested() {
        return totalInvested;
    }

    public double getProfit() {
        return profit;
    }
}
