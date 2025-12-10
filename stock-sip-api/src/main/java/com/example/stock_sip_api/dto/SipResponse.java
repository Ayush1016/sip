//package com.example.stock_sip_api.dto;
//
//public class SipResponse {
//
//    private double totalInvested;
//    private double futureValue;
//    private double profit;
//
//    public double getTotalInvested() {
//        return totalInvested;
//    }
//
//    public void setTotalInvested(double totalInvested) {
//        this.totalInvested = totalInvested;
//    }
//
//    public double getFutureValue() {
//        return futureValue;
//    }
//
//    public void setFutureValue(double futureValue) {
//        this.futureValue = futureValue;
//    }
//
//    public double getProfit() {
//        return profit;
//    }
//
//    public void setProfit(double profit) {
//        this.profit = profit;
//    }
//}
package com.example.stock_sip_api.dto;

import java.util.List;

public class SipResponse {

    private double totalInvested;
    private double futureValue;
    private double profit;

    private double realFutureValue;   // inflation-adjusted
    private double realProfit;        // inflation-adjusted profit

    private List<YearlyProjection> projections; // for chart

    public double getTotalInvested() {
        return totalInvested;
    }

    public void setTotalInvested(double totalInvested) {
        this.totalInvested = totalInvested;
    }

    public double getFutureValue() {
        return futureValue;
    }

    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getRealFutureValue() {
        return realFutureValue;
    }

    public void setRealFutureValue(double realFutureValue) {
        this.realFutureValue = realFutureValue;
    }

    public double getRealProfit() {
        return realProfit;
    }

    public void setRealProfit(double realProfit) {
        this.realProfit = realProfit;
    }

    public List<YearlyProjection> getProjections() {
        return projections;
    }

    public void setProjections(List<YearlyProjection> projections) {
        this.projections = projections;
    }
}
