package com.headhunter.client.viewmodel.company;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CompanyInfoFactory implements ViewModelProvider.Factory {

    String id;

    public CompanyInfoFactory(String id) {
        this.id = id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CompanyDetailViewModel(id);
    }
}
