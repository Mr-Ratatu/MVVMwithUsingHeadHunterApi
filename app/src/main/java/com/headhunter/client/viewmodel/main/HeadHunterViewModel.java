package com.headhunter.client.viewmodel.main;

import android.app.Application;
import android.util.Log;
import android.view.View;

import com.headhunter.client.ui.adapter.HeadHunterAdapter;
import com.headhunter.client.data.paging.HeadHunterSourceFactory;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.utils.Constant;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;

public class HeadHunterViewModel extends AndroidViewModel {

    private HeadHunterSourceFactory headHunterSourceFactory;
    private LiveData<PagedList<ItemHunter>> pagedListLiveData;
    private ObservableInt error;
    private ObservableInt loadingContent;

    public HeadHunterViewModel(@NonNull Application application, int area, String text) {
        super(application);

        headHunterSourceFactory = new HeadHunterSourceFactory(area, text);

        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(20)
                .setPrefetchDistance(4)
                .build();

        Executor executor = Executors.newFixedThreadPool(5);

        pagedListLiveData = (new LivePagedListBuilder<Long, ItemHunter>(headHunterSourceFactory, config))
                .setFetchExecutor(executor)
                .build();

        error = headHunterSourceFactory.getError();
        loadingContent = headHunterSourceFactory.getLoadingContent();
    }

    public LiveData<PagedList<ItemHunter>> getPagedListLiveData() {
        return pagedListLiveData;
    }

    public HeadHunterSourceFactory getAdapter() {
        return headHunterSourceFactory;
    }

    public ObservableInt getError() {
        return error;
    }

    public ObservableInt getLoadingContent() {
        return loadingContent;
    }
}
