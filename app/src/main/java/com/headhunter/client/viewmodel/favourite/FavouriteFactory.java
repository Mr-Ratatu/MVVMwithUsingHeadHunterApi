package com.headhunter.client.viewmodel.favourite;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class FavouriteFactory implements ViewModelProvider.Factory {

    private Application application;

    public FavouriteFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new FavouriteViewModel(application);
    }
}
