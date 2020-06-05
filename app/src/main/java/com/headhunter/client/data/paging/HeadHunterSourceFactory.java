package com.headhunter.client.data.paging;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class HeadHunterSourceFactory extends DataSource.Factory {

    private MyPositionalDataSource myPositionalDataSource;
    private MutableLiveData<MyPositionalDataSource> mutableLiveData;

    private int area;
    private String text;

    public HeadHunterSourceFactory(int area, String text) {
        this.area = area;
        this.text = text;

        mutableLiveData = new MutableLiveData<>();
    }

    @NonNull
    @Override
    public DataSource create() {
        myPositionalDataSource = new MyPositionalDataSource(area, text);
        mutableLiveData.postValue(myPositionalDataSource);

        return myPositionalDataSource;
    }

    public MutableLiveData<MyPositionalDataSource> getMutableLiveData() {
        return mutableLiveData;
    }

}
