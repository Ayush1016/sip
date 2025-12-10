//package com.example.stock_sip_api.dto;
//
//public class MfMeta {
//
//    private String fund_house;
//    private String scheme_type;
//    private String scheme_category;
//    private int scheme_code;
//    private String scheme_name;
//
//    public String getFund_house() { return fund_house; }
//    public void setFund_house(String fund_house) { this.fund_house = fund_house; }
//
//    public String getScheme_type() { return scheme_type; }
//    public void setScheme_type(String scheme_type) { this.scheme_type = scheme_type; }
//
//    public String getScheme_category() { return scheme_category; }
//    public void setScheme_category(String scheme_category) { this.scheme_category = scheme_category; }
//
//    public int getScheme_code() { return scheme_code; }
//    public void setScheme_code(int scheme_code) { this.scheme_code = scheme_code; }
//
//    public String getScheme_name() { return scheme_name; }
//    public void setScheme_name(String scheme_name) { this.scheme_name = scheme_name; }
//}
package com.example.stock_sip_api.dto;

public class MfMeta {

    private String schemeCode;
    private String schemeName;
    private String fundHouse;
    private String category;
    private String riskLevel;

    private double return1yr;
    private double return3yr;
    private double return5yr;

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

    public double getReturn1yr() {
        return return1yr;
    }
    public void setReturn1yr(double return1yr) {
        this.return1yr = return1yr;
    }

    public double getReturn3yr() {
        return return3yr;
    }
    public void setReturn3yr(double return3yr) {
        this.return3yr = return3yr;
    }

    public double getReturn5yr() {
        return return5yr;
    }
    public void setReturn5yr(double return5yr) {
        this.return5yr = return5yr;
    }
}
