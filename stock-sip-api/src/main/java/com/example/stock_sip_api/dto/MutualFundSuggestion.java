package com.example.stock_sip_api.dto;

public class MutualFundSuggestion {

    private String schemeName;
    private int schemeCode;          // from MFAPI.in
    private String category;         // e.g. "Small Cap", "Flexi Cap"
    private String riskLevel;        // e.g. "High", "Moderate"
    private double typicalReturnPercent; // your default expected annual return for SIP
    private String fundHouse;        // e.g. "Quant MF", "HDFC MF"

    public MutualFundSuggestion() {
    }

    public MutualFundSuggestion(String schemeName, int schemeCode, String category,
                                String riskLevel, double typicalReturnPercent, String fundHouse) {
        this.schemeName = schemeName;
        this.schemeCode = schemeCode;
        this.category = category;
        this.riskLevel = riskLevel;
        this.typicalReturnPercent = typicalReturnPercent;
        this.fundHouse = fundHouse;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public int getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(int schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public double getTypicalReturnPercent() {
        return typicalReturnPercent;
    }

    public void setTypicalReturnPercent(double typicalReturnPercent) {
        this.typicalReturnPercent = typicalReturnPercent;
    }

    public String getFundHouse() {
        return fundHouse;
    }

    public void setFundHouse(String fundHouse) {
        this.fundHouse = fundHouse;
    }
}
