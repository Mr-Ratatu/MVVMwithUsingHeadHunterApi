package com.headhunter.client.viewmodel.detail;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class DetailViewModelFactory implements ViewModelProvider.Factory {

    private String id;

    public DetailViewModelFactory(String id) {
        this.id = id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new DetailViewModel(id);
    }
}
