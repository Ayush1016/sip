package com.example.stock_sip_api.dto;

public class LiveMutualFundDto {

    private String schemeCode;
    private String schemeName;

    private String fundHouse;    // from MFAPI meta
    private String category;     // from MFAPI meta
    private String riskLevel;    // we’ll keep this null for now or derive later if you want

    /**
     * Real trailing return % (approx) calculated from NAV history,
     * usually around 1-year simple return.
     */
    private Double returnPercent;

    /**
     * Optional fallback if you want to combine with your static suggestions.
     * Not used by the live API directly, but frontend can read it.
     */
    private Double typicalReturnPercent;

    public LiveMutualFundDto() {
    }

    public LiveMutualFundDto(
            String schemeCode,
            String schemeName,
            String fundHouse,
            String category,
            String riskLevel,
            Double returnPercent,
            Double typicalReturnPercent
    ) {
        this.schemeCode = schemeCode;
        this.schemeName = schemeName;
        this.fundHouse = fundHouse;
        this.category = category;
        this.riskLevel = riskLevel;
        this.returnPercent = returnPercent;
        this.typicalReturnPercent = typicalReturnPercent;
    }

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

    public Double getReturnPercent() {
        return returnPercent;
    }

    public void setReturnPercent(Double returnPercent) {
        this.returnPercent = returnPercent;
    }

    public Double getTypicalReturnPercent() {
        return typicalReturnPercent;
    }

    public void setTypicalReturnPercent(Double typicalReturnPercent) {
        this.typicalReturnPercent = typicalReturnPercent;
    }
}
