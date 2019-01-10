package com.egberts.jimmy.gamelibrary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class Games {

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("limit")
    @Expose
    private Integer limit;

    @SerializedName("offset")
    @Expose
    private Integer offset;

    @SerializedName("number_of_page_results")
    @Expose
    private Integer number_of_page_results;

    @SerializedName("number_of_total_results")
    @Expose
    private Integer number_of_total_results;

    @SerializedName("status_code")
    @Expose
    private Integer status_code;

    @SerializedName("results")
    @Expose
    private ArrayList<GameAPIItem> results;

    @SerializedName("version")
    @Expose
    private String version;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getNumber_of_page_results() {
        return number_of_page_results;
    }

    public void setNumber_of_page_results(Integer number_of_page_results) {
        this.number_of_page_results = number_of_page_results;
    }

    public Integer getNumber_of_total_results() {
        return number_of_total_results;
    }

    public void setNumber_of_total_results(Integer number_of_total_results) {
        this.number_of_total_results = number_of_total_results;
    }

    public Integer getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    ArrayList<GameAPIItem> getResults() {
        return results;
    }

    public void setResults(ArrayList<GameAPIItem> results) {
        this.results = results;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
