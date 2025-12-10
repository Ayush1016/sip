package com.example.stock_sip_api.dto;

import java.util.List;

public class MfNavHistory {

    private MfMeta meta;
    private List<MfNavEntry> data;
    private String status;

    public MfMeta getMeta() {
        return meta;
    }

    public void setMeta(MfMeta meta) {
        this.meta = meta;
    }

    public List<MfNavEntry> getData() {
        return data;
    }

    public void setData(List<MfNavEntry> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
