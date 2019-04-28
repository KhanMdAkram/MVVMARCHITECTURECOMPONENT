package com.sample.mvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.sample.mvvm.model.ApiResponseStatus;
import com.sample.mvvm.network.CallApi;

import java.util.List;

/**
 * Created by khanak7 on 28/04/19.
 */

public class CustomViewModel extends ViewModel {
    CallApi mCallApi;

    CustomViewModel() {
        mCallApi = new CallApi();
    }

    public void callNytApi() {
        mCallApi.callNytMostPopularApi();
    }

    public MutableLiveData<ApiResponseStatus> getApiResponse() {
        return mCallApi.getApiResponse();
    }
}
