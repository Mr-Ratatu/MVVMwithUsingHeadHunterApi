package com.headhunter.client.viewmodel.detail;

import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.data.model.detail.DetailModelBody;
import com.headhunter.client.data.network.responce.HeadHunterBody;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {
    private MutableLiveData<DetailModelBody> headHunterBodyLiveData;
    private ObservableInt loading;
    private ObservableInt contentLoading;
    private ObservableInt error;

    public DetailViewModel(String id) {
        headHunterBodyLiveData = DetailRepository.getInstance().getDetailApi(id);
        loading = DetailRepository.getInstance().getLoadingProgress();
        contentLoading = DetailRepository.getInstance().getContent();
        error = DetailRepository.getInstance().getError();
    }

    public MutableLiveData<DetailModelBody> getHeadHunterBodyLiveData() {
        return headHunterBodyLiveData;
    }

    public ObservableInt getLoading() {
        return loading;
    }

    public ObservableInt getContentLoading() {
        return contentLoading;
    }

    public ObservableInt getError() {
        return error;
    }
}
