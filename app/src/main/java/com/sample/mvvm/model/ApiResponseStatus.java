package com.sample.mvvm.model;

import java.util.List;

/**
 * Created by khanak7 on 26/04/19.
 */

public class ApiResponseStatus {
    private ApiResponseType apiResponseType;
    private List<Results> resultsList;

    public ApiResponseStatus(List<Results> resultsList, ApiResponseType apiResponseType) {
        this.resultsList =  resultsList;
        this.apiResponseType = apiResponseType;
    }

    public ApiResponseType getApiResponseType() {
        return apiResponseType;
    }

    public List<Results> getResultsList() {
        return resultsList;
    }
}
