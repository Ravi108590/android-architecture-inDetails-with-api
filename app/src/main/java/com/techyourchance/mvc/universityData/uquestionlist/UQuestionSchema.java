package com.techyourchance.mvc.universityData.uquestionlist;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UQuestionSchema {

    @SerializedName("country")
    private final String country;
    @SerializedName("web_pages")
    private final List<String> webPages;
    @SerializedName("alpha_two_code")
    private final String alphaTwoCode;
    @SerializedName("domains")
    private final List<String> domains;
    @SerializedName("state_province")
    private final String stateProvince;
    @SerializedName("name")
    private final String name;

    public UQuestionSchema(String country, List<String> webPages, String alphaTwoCode, List<String> domains, String stateProvince, String name) {
        this.country = country;
        this.webPages = webPages;
        this.alphaTwoCode = alphaTwoCode;
        this.domains = domains;
        this.stateProvince = stateProvince;
        this.name = name;
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

    public String getName() {
        return name;
    }
}
