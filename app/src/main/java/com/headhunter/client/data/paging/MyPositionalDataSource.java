package com.headhunter.client.data.paging;

import android.view.View;

import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.data.network.ApiFactory;
import com.headhunter.client.data.network.ApiService;
import com.headhunter.client.utils.NetworkState;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyPositionalDataSource extends PageKeyedDataSource<Long, ItemHunter> {

    private ApiService apiService;
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<NetworkState> loading;

    private int area;
    private String text;

    public MyPositionalDataSource(int area, String text) {
        this.area = area;
        this.text = text;
        apiService = ApiFactory.getInstance().getApiService();
        compositeDisposable = new CompositeDisposable();
        loading = new MutableLiveData<>();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull final LoadInitialCallback<Long, ItemHunter> callback) {
        loading.postValue(NetworkState.LOADING);

        Disposable disposable = apiService.getVacancies(area, text, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(headHunterBody -> {
                    loading.postValue(NetworkState.LOADED);
                    List<ItemHunter> list = headHunterBody.getItems();
                    callback.onResult(list, null, (long) 2);
                }, Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, ItemHunter> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Long> params, @NonNull final LoadCallback<Long, ItemHunter> callback) {
        loading.postValue(NetworkState.LOADING);

        Disposable disposable = apiService.getVacancies(area, text, params.key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(headHunterBody -> {
                    loading.postValue(NetworkState.LOADED);
                    List<ItemHunter> list = headHunterBody.getItems();
                    callback.onResult(list, params.key + 1);
                }, Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

}