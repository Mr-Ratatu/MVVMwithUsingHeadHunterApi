package com.headhunter.client.viewmodel.company;

import android.view.View;

import com.headhunter.client.data.model.company.CompanyInfoBody;
import com.headhunter.client.data.network.ApiService;
import com.headhunter.client.data.network.ApiFactory;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CompanyDetailRepository {

    private static CompanyDetailRepository instance;
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;

    private ObservableInt error;
    private ObservableInt loading;
    private ObservableInt content;

    private CompanyDetailRepository() {
        apiService = ApiFactory.getInstance().getApiService();
        compositeDisposable = new CompositeDisposable();

        error = new ObservableInt();
        loading = new ObservableInt();
        content = new ObservableInt();
    }

    public static CompanyDetailRepository getInstance() {
        if (instance == null) {
            instance = new CompanyDetailRepository();
        }

        return instance;
    }

    public MutableLiveData<CompanyInfoBody> getCompanyInfo(String id) {
        MutableLiveData<CompanyInfoBody> liveData = new MutableLiveData<>();

        error.set(View.GONE);
        loading.set(View.VISIBLE);
        content.set(View.GONE);

        compositeDisposable.add(apiService.getCompanyInfo(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(companyInfoBody -> {
                    liveData.setValue(companyInfoBody);
                    content.set(View.VISIBLE);
                    loading.set(View.GONE);
                }, throwable -> {
                    loading.set(View.GONE);
                    error.set(View.VISIBLE);
                    throwable.printStackTrace();
                }));

        return liveData;
    }

    public ObservableInt getError() {
        return error;
    }

    public ObservableInt getLoading() {
        return loading;
    }

    public ObservableInt getContent() {
        return content;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }
}
