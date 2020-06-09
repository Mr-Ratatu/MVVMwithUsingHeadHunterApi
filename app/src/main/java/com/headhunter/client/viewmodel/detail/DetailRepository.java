package com.headhunter.client.viewmodel.detail;

import android.view.View;

import com.headhunter.client.data.model.detail.DetailModelBody;
import com.headhunter.client.data.network.ApiFactory;
import com.headhunter.client.data.network.ApiService;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailRepository {

    private static DetailRepository detailRepository;
    private ApiService apiService;
    private CompositeDisposable compositeDisposable;

    private ObservableInt loadingProgress;
    private ObservableInt content;
    private ObservableInt error;

    private DetailRepository() {
        apiService = ApiFactory.getInstance().getApiService();
        compositeDisposable = new CompositeDisposable();
        loadingProgress = new ObservableInt();
        content = new ObservableInt();
        error = new ObservableInt();
    }

    public static DetailRepository getInstance() {
        if (detailRepository == null) {
            detailRepository = new DetailRepository();
        }

        return detailRepository;
    }

    public MutableLiveData<DetailModelBody> getDetailApi(String id) {
        MutableLiveData<DetailModelBody> liveData = new MutableLiveData<>();

        loadingProgress.set(View.VISIBLE);
        content.set(View.GONE);
        error.set(View.GONE);

        Disposable disposable = apiService.getIdVacancies(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        detailModelBody -> {
                            liveData.setValue(detailModelBody);
                            content.set(View.VISIBLE);
                            loadingProgress.set(View.GONE);
                        },
                        throwable -> {
                            throwable.printStackTrace();
                            loadingProgress.set(View.GONE);
                            error.set(View.VISIBLE);
                        });

        compositeDisposable.add(disposable);

        return liveData;
    }

    public ObservableInt getLoadingProgress() {
        return loadingProgress;
    }

    public ObservableInt getContent() {
        return content;
    }

    public ObservableInt getError() {
        return error;
    }
}
