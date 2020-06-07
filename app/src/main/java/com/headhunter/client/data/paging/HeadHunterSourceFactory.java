package com.headhunter.client.data.paging;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class HeadHunterSourceFactory extends DataSource.Factory {

    private MyPositionalDataSource myPositionalDataSource;
    private MutableLiveData<MyPositionalDataSource> mutableLiveData;
    private ObservableInt error;
    private ObservableInt loadingContent;

    public HeadHunterSourceFactory(int area, String text) {
        myPositionalDataSource = new MyPositionalDataSource(area, text);
        mutableLiveData = new MutableLiveData<>();
        error = myPositionalDataSource.getError();
        loadingContent = myPositionalDataSource.getLoadingContent();
    }

    @NonNull
    @Override
    public DataSource create() {
        mutableLiveData.postValue(myPositionalDataSource);


        return myPositionalDataSource;
    }

    public MutableLiveData<MyPositionalDataSource> getMutableLiveData() {
        return mutableLiveData;
    }

    public ObservableInt getError() {
        return error;
    }

    public ObservableInt getLoadingContent() {
        return loadingContent;
    }
}
