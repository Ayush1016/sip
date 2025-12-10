//
//package com.example.stock_sip_api.dto;
//
//public class SipRequest {
//    private double monthlyInvestment;
//    private int tenureYears;
//    private double annualReturnRate;
//
//    public double getMonthlyInvestment() {
//        return monthlyInvestment;
//    }
//
//    public void setMonthlyInvestment(double monthlyInvestment) {
//        this.monthlyInvestment = monthlyInvestment;
//    }
//
//    public int getTenureYears() {
//        return tenureYears;
//    }
//
//    public void setTenureYears(int tenureYears) {
//        this.tenureYears = tenureYears;
//    }
//
//    public double getAnnualReturnRate() {
//        return annualReturnRate;
//    }
//
//    public void setAnnualReturnRate(double annualReturnRate) {
//        this.annualReturnRate = annualReturnRate;
//    }
//}
package com.example.stock_sip_api.dto;

public class SipRequest {

    private double monthlyInvestment;   // periodic investment (monthly/weekly UI)
    private int tenureYears;
    private double annualReturnRate;

    private double lumpSumInvestment;   // new
    private double inflationRate;       // new (in %)
    private String frequency;           // "MONTHLY" or "WEEKLY"

    public double getMonthlyInvestment() {
        return monthlyInvestment;
    }

    public void setMonthlyInvestment(double monthlyInvestment) {
        this.monthlyInvestment = monthlyInvestment;
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

    public double getLumpSumInvestment() {
        return lumpSumInvestment;
    }

    public void setLumpSumInvestment(double lumpSumInvestment) {
        this.lumpSumInvestment = lumpSumInvestment;
    }

    public double getInflationRate() {
        return inflationRate;
    }

    public void setInflationRate(double inflationRate) {
        this.inflationRate = inflationRate;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
