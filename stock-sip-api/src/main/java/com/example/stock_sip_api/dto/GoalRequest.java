package com.example.stock_sip_api.dto;

public class GoalRequest {
    private double targetAmount;
    private int tenureYears;
    private double annualReturnRate;

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public int getTenureYears() {
        return tenureYears;
    }

    public void setTenureYears(int tenureYears) {
        this.tenureYears = tenureYears;
    }

    public double getAnnualReturnRate() {
        return annualReturnRate;
    }

    public void setAnnualReturnRate(double annualReturnRate) {
        this.annualReturnRate = annualReturnRate;
    }
}
