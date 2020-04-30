package com.headhunter.client.data.paging;

import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.data.network.ApiFactory;
import com.headhunter.client.data.network.ApiService;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyPositionalDataSource extends PageKeyedDataSource<Long, ItemHunter> {

    private ApiService apiService;
    private CompositeDisposable compositeDisposable;

    private int area;
    private String text;
    private int page;

    public MyPositionalDataSource(int area, String text, int page) {
        this.area = area;
        this.text = text;
        this.page = page;
        apiService = ApiFactory.getInstance().getApiService();
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull final LoadInitialCallback<Long, ItemHunter> callback) {
        Disposable disposable = apiService.getVacancies(area, text, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(headHunterBody -> {
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
        Disposable disposable = apiService.getVacancies(area, text, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(headHunterBody -> {
                    List<ItemHunter> list = headHunterBody.getItems();
                    callback.onResult(list, params.key + 1);
                }, Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

}