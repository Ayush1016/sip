package com.example.stock_sip_api.dto;

public class FundInsightDto {

    private String schemeCode;
    private String schemeName;
    private String fundHouse;
    private String category;
    private String riskLevel;
    private Double expenseRatio; // %

    private Double return1M;
    private Double return6M;
    private Double return1Y;
    private Double return3Y;
    private Double return5Y;
    private Double return10Y;

    private String styleTag;  // e.g. "Aggressive long-term"
    private String summary;   // 2–3 lines

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getFundHouse() {
        return fundHouse;
    }

    public void setFundHouse(String fundHouse) {
        this.fundHouse = fundHouse;
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

    public Double getExpenseRatio() {
        return expenseRatio;
    }

    public void setExpenseRatio(Double expenseRatio) {
        this.expenseRatio = expenseRatio;
    }

    public Double getReturn1M() {
        return return1M;
    }

    public void setReturn1M(Double return1M) {
        this.return1M = return1M;
    }

    public Double getReturn6M() {
        return return6M;
    }

    public void setReturn6M(Double return6M) {
        this.return6M = return6M;
    }

    public Double getReturn1Y() {
        return return1Y;
    }

    public void setReturn1Y(Double return1Y) {
        this.return1Y = return1Y;
    }

    public Double getReturn3Y() {
        return return3Y;
    }

    public void setReturn3Y(Double return3Y) {
        this.return3Y = return3Y;
    }

    public Double getReturn5Y() {
        return return5Y;
    }

    public void setReturn5Y(Double return5Y) {
        this.return5Y = return5Y;
    }

    public Double getReturn10Y() {
        return return10Y;
    }

    public void setReturn10Y(Double return10Y) {
        this.return10Y = return10Y;
    }

    public String getStyleTag() {
        return styleTag;
    }

    public void setStyleTag(String styleTag) {
        this.styleTag = styleTag;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
