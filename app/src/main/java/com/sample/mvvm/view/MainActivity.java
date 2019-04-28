package com.sample.mvvm.view;

import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.sample.mvvm.R;
import com.sample.mvvm.databinding.ActivityMainBinding;
import com.sample.mvvm.model.ApiResponseStatus;
import com.sample.mvvm.model.Results;
import com.sample.mvvm.viewmodel.CustomViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CustomViewModel mCustomeViewModel;
    private ProgressDialog mProgressDialog;
    private MostViewAdapter mMostViewedAdapter;
    private ActivityMainBinding mActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mCustomeViewModel = ViewModelProviders.of(this).get(CustomViewModel.class);
        setAdapter();
        showProgressDialog("Getting Results");
        mCustomeViewModel.callNytApi();
        observeApiResponse();
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mActivityBinding.recyclerViews.setLayoutManager(linearLayoutManager);
        mMostViewedAdapter = new MostViewAdapter(this);
        mActivityBinding.recyclerViews.setAdapter(mMostViewedAdapter);
    }

    private void observeApiResponse() {
        mCustomeViewModel.getApiResponse().observe((LifecycleOwner) this, new Observer<ApiResponseStatus>() {
            @Override
            public void onChanged(@Nullable ApiResponseStatus status) {
                dismissProgressDialog();
                switch (status.getApiResponseType()) {
                    case SUCCESS:
                        if (status.getResultsList() != null) {
                            setResultData(status.getResultsList());
                        }
                        break;
                    case ERROR:
                        Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public void setResultData(List<Results> resultsList) {
        mMostViewedAdapter.setResultsList(resultsList);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_refresh, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (isNetworkAvailable()) {
            showProgressDialog("Getting Results");
            mCustomeViewModel.callNytApi();
        } else {
            Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    private void showProgressDialog(String message) {
        if (isFinishing()) {
            return;
        }
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
        }
        mProgressDialog.setMessage(message);
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    private void dismissProgressDialog() {
        if (!isFinishing() && mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
