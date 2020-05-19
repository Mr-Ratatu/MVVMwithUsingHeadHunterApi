package com.headhunter.client.viewmodel.main;

import android.app.Application;
import android.view.View;

import com.headhunter.client.ui.adapter.HeadHunterAdapter;
import com.headhunter.client.data.paging.HeadHunterSourceFactory;
import com.headhunter.client.data.model.ItemHunter;

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
    private Executor executor;
    private LiveData<PagedList<ItemHunter>> pagedListLiveData;
    private RecyclerView.Adapter headHunterAdapter;
    public ObservableInt loading;

    public HeadHunterViewModel(@NonNull Application application, int area, String text, int page) {
        super(application);

        loading = new ObservableInt(View.VISIBLE);

        headHunterAdapter = new HeadHunterAdapter();
        headHunterSourceFactory = new HeadHunterSourceFactory(area, text, page);

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

    }

    public LiveData<PagedList<ItemHunter>> getPagedListLiveData() {
        return pagedListLiveData;
    }

    public HeadHunterSourceFactory getAdapter() {
        return headHunterSourceFactory;
    }

}
