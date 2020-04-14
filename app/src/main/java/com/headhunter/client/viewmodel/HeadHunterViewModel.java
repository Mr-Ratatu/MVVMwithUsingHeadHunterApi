package com.headhunter.client.viewmodel;

import android.app.Application;

import com.headhunter.client.data.source.HeadHunterSourceFactory;
import com.headhunter.client.data.source.MyPositionalDataSource;
import com.headhunter.client.data.model.ItemHunter;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class HeadHunterViewModel extends AndroidViewModel {

    private HeadHunterRepository hunterRepository;
    private MutableLiveData<List<ItemHunter>> mutableLiveData;

    private HeadHunterSourceFactory headHunterSourceFactory;
    private MutableLiveData<MyPositionalDataSource> mutableLiveDataSource;
    private Executor executor;
    private LiveData<PagedList<ItemHunter>> pagedListLiveData;

    public HeadHunterViewModel(@NonNull Application application, int area, String text, int page) {
        super(application);

        headHunterSourceFactory = new HeadHunterSourceFactory(area, text, page);
        mutableLiveDataSource = headHunterSourceFactory.getMutableLiveData();

        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(20)
                .setPrefetchDistance(4)
                .build();

        executor = Executors.newFixedThreadPool(5);

        pagedListLiveData = (new LivePagedListBuilder<Long, ItemHunter>(headHunterSourceFactory, config))
                .setFetchExecutor(executor)
                .build();

        hunterRepository = HeadHunterRepository.getInstance(application);
        mutableLiveData = hunterRepository.getItemHunter(area, text, page);
    }

    public MutableLiveData<List<ItemHunter>> getMutableLiveData() {
        return mutableLiveData;
    }

    public LiveData<PagedList<ItemHunter>> getPagedListLiveData() {
        return pagedListLiveData;
    }
}
