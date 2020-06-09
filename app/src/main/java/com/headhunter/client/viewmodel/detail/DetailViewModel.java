package com.headhunter.client.viewmodel.detail;

import android.os.Bundle;
import android.view.View;

import com.headhunter.client.R;
import com.headhunter.client.data.model.detail.DetailModelBody;
import com.headhunter.client.utils.Constant;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

public class DetailViewModel extends ViewModel {
    private MutableLiveData<DetailModelBody> headHunterBodyLiveData;
    private ObservableInt loading;
    private ObservableInt contentLoading;
    private ObservableInt error;

    public DetailViewModel(String id) {
        DetailRepository detailRepository = DetailRepository.getInstance();

        headHunterBodyLiveData = detailRepository.getDetailApi(id);
        loading = detailRepository.getLoadingProgress();
        contentLoading = detailRepository.getContent();
        error = detailRepository.getError();
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

    public void onOpenDetailInfoAboutCompany(View view, String id) {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.ID_COMPANY, id);

        Navigation.findNavController(view).navigate(R.id.detail_icompany, bundle);
    }
}
