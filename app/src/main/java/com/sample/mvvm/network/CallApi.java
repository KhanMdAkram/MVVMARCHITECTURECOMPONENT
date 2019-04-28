package com.sample.mvvm.network;

import android.arch.lifecycle.MutableLiveData;

import com.sample.mvvm.model.ApiResponseStatus;
import com.sample.mvvm.model.ApiResponseType;
import com.sample.mvvm.model.MostViewedResponse;
import com.sample.mvvm.model.Results;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by akram on 28/04/19.
 */

public class CallApi {

    private MutableLiveData<ApiResponseStatus> mResponseLiveData = new MutableLiveData<>();


    public MutableLiveData<ApiResponseStatus> getApiResponse() {
        return mResponseLiveData;
    }


    public void callNytMostPopularApi() {
        getObservable().subscribeWith(getObserver());
    }

    public Observable<MostViewedResponse> getObservable() {
        return ApiServiceSingleton.getInstance()
                .getMostView("all-sections", "7")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observer<MostViewedResponse> getObserver() {
        return new Observer<MostViewedResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MostViewedResponse mostViewedResponse) {
                if (mostViewedResponse.getResults() != null) {
                    mResponseLiveData.setValue(new ApiResponseStatus(mostViewedResponse.getResults(), ApiResponseType.SUCCESS));
                }
            }

            @Override
            public void onError(Throwable e) {
                mResponseLiveData.setValue(new ApiResponseStatus(null, ApiResponseType.ERROR));
            }

            @Override
            public void onComplete() {

            }
        };

    }

}
