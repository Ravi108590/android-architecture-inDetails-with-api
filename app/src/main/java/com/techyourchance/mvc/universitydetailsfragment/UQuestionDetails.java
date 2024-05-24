package com.techyourchance.mvc.universitydetailsfragment;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UQuestionDetails {


    private final String country;
    private final List<String> webPages;
    private final String alphaTwoCode;
    private final List<String> domains;
    private final String stateProvince;

    public UQuestionDetails(String country, List<String> webPages, String alphaTwoCode, List<String> domains, String stateProvince) {
        this.country = country;
        this.webPages = webPages;
        this.alphaTwoCode = alphaTwoCode;
        this.domains = domains;
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getWebPages() {
        return webPages;
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public List<String> getDomains() {
        return domains;
    }

    public String getStateProvince() {
        return stateProvince;
    }

}
