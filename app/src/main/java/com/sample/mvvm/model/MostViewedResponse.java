package com.sample.mvvm.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by akram on 19/11/18.
 */

public class MostViewedResponse implements Serializable {
    private List<Results> results;

    private String status;

    private String num_results;

    private String copyright;

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNum_results() {
        return num_results;
    }

    public void setNum_results(String num_results) {
        this.num_results = num_results;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @Override
    public String toString() {
        return "MostViewedResponse [results = " + results + ", status = " + status + ", num_results = " + num_results + ", copyright = " + copyright + "]";
    }
}
