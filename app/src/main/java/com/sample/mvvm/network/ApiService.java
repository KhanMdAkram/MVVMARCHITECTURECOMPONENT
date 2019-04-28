package com.sample.mvvm.network;


import com.sample.mvvm.model.MostViewedResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    String API_KEY = "azlAocLMRQkSJBM1eNb4zDrw4niej2pj";
    String BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/";

    @GET("mostviewed/{section}/{time-period}.json")
    Observable<MostViewedResponse> getMostView(
            @Path("section") String section,
            @Path("time-period") String timeperiod);
}
