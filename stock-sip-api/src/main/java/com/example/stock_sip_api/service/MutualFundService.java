package com.example.stock_sip_api.service;

import com.example.stock_sip_api.dto.MutualFundSuggestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MutualFundService {

    /**
     * Local curated list of mutual funds.
     * This is used by /api/mutual-funds/suggestions
     */
    public List<MutualFundSuggestion> getSuggestedFunds() {

        List<MutualFundSuggestion> list = new ArrayList<>();

        // 1) SBI Bluechip
        {
            MutualFundSuggestion mf = new MutualFundSuggestion();
            mf.setSchemeName("SBI Bluechip Fund");
            mf.setFundHouse("SBI Mutual Fund");
            mf.setCategory("Large Cap");
            mf.setRiskLevel("Moderate");
            mf.setTypicalReturnPercent(12.5);
            list.add(mf);
        }

        // 2) HDFC Midcap Opportunities
        {
            MutualFundSuggestion mf = new MutualFundSuggestion();
            mf.setSchemeName("HDFC Midcap Opportunities Fund");
            mf.setFundHouse("HDFC Mutual Fund");
            mf.setCategory("Mid Cap");
            mf.setRiskLevel("High");
            mf.setTypicalReturnPercent(14.5);
            list.add(mf);
        }

        // 3) ICICI Prudential Balanced Advantage
        {
            MutualFundSuggestion mf = new MutualFundSuggestion();
            mf.setSchemeName("ICICI Pru Balanced Advantage Fund");
            mf.setFundHouse("ICICI Prudential Mutual Fund");
            mf.setCategory("Balanced / Dynamic Asset");
            mf.setRiskLevel("Moderate");
            mf.setTypicalReturnPercent(11.0);
            list.add(mf);
        }

        // 4) Axis Long Term Equity
        {
            MutualFundSuggestion mf = new MutualFundSuggestion();
            mf.setSchemeName("Axis Long Term Equity Fund");
            mf.setFundHouse("Axis Mutual Fund");
            mf.setCategory("ELSS / Tax Saver");
            mf.setRiskLevel("Moderate-High");
            mf.setTypicalReturnPercent(13.0);
            list.add(mf);
        }

        // 5) Nippon India Small Cap
        {
            MutualFundSuggestion mf = new MutualFundSuggestion();
            mf.setSchemeName("Nippon India Small Cap Fund");
            mf.setFundHouse("Nippon India Mutual Fund");
            mf.setCategory("Small Cap");
            mf.setRiskLevel("High");
            mf.setTypicalReturnPercent(16.0);
            list.add(mf);
        }

        return list;
    }
}
