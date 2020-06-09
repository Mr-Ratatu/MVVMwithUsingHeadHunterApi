package com.headhunter.client.data.paging;

import android.util.Log;
import android.view.View;

import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.data.network.ApiFactory;
import com.headhunter.client.data.network.ApiService;
import com.headhunter.client.utils.Constant;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableInt;
import androidx.paging.PageKeyedDataSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyPositionalDataSource extends PageKeyedDataSource<Long, ItemHunter> {

    private ApiService apiService;
    private CompositeDisposable compositeDisposable;
    private ObservableInt error;
    private ObservableInt loadingContent;

    private int area;
    private String text;

    public MyPositionalDataSource(int area, String text) {
        this.area = area;
        this.text = text;
        apiService = ApiFactory.getInstance().getApiService();
        compositeDisposable = new CompositeDisposable();

        error = new ObservableInt();
        loadingContent = new ObservableInt();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull final LoadInitialCallback<Long, ItemHunter> callback) {
        loadingContent.set(View.VISIBLE);
        error.set(View.GONE);

        Disposable disposable = apiService.getVacancies(area, text, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(headHunterBody -> {
                    List<ItemHunter> list = headHunterBody.getItems();
                    callback.onResult(list, null, (long) 2);
                    loadingContent.set(View.GONE);
                }, throwable -> {
                    throwable.printStackTrace();
                    error.set(View.VISIBLE);
                    loadingContent.set(View.GONE);
                    Log.d(Constant.ERROR, "error: " + error.get());
                });

        compositeDisposable.add(disposable);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, ItemHunter> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Long> params, @NonNull final LoadCallback<Long, ItemHunter> callback) {

        Disposable disposable = apiService.getVacancies(area, text, params.key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(headHunterBody -> {
                    List<ItemHunter> list = headHunterBody.getItems();
                    callback.onResult(list, params.key + 1);
                }, Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

    public ObservableInt getError() {
        return error;
    }

    public ObservableInt getLoadingContent() {
        return loadingContent;
    }
}