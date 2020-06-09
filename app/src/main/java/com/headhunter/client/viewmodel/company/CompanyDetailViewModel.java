package com.headhunter.client.viewmodel.company;

import com.headhunter.client.data.model.company.CompanyInfoBody;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class CompanyDetailViewModel extends ViewModel {
    private MutableLiveData<CompanyInfoBody> infoLiveData;

    private ObservableInt error;
    private ObservableInt loading;
    private ObservableInt content;

    public CompanyDetailViewModel(String id) {
        CompanyDetailRepository companyDetailRepository = CompanyDetailRepository.getInstance();
        infoLiveData = companyDetailRepository.getCompanyInfo(id);

        error = companyDetailRepository.getError();
        loading = companyDetailRepository.getLoading();
        content = companyDetailRepository.getContent();
    }

    public MutableLiveData<CompanyInfoBody> getInfoLiveData() {
        return infoLiveData;
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

}
