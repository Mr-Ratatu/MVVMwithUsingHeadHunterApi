package com.headhunter.client.data.paging;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class HeadHunterSourceFactory extends DataSource.Factory {

    private MyPositionalDataSource myPositionalDataSource;
    private MutableLiveData<MyPositionalDataSource> mutableLiveData;

    private int area;
    private String text;
    private int page;

    public HeadHunterSourceFactory(int area, String text, int page) {
        this.area = area;
        this.text = text;
        this.page = page;

        mutableLiveData = new MutableLiveData<>();
    }

    @NonNull
    @Override
    public DataSource create() {
        myPositionalDataSource = new MyPositionalDataSource(area, text, page);
        mutableLiveData.postValue(myPositionalDataSource);

        return myPositionalDataSource;
    }

    public MutableLiveData<MyPositionalDataSource> getMutableLiveData() {
        return mutableLiveData;
    }

}
