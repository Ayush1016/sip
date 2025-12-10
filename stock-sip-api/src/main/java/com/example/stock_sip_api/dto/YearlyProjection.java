package com.example.stock_sip_api.dto;

public class YearlyProjection {

    private int year;
    private double invested;
    private double value;

    public YearlyProjection() {
    }

    public YearlyProjection(int year, double invested, double value) {
        this.year = year;
        this.invested = invested;
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getInvested() {
        return invested;
    }

    public void setInvested(double invested) {
        this.invested = invested;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
