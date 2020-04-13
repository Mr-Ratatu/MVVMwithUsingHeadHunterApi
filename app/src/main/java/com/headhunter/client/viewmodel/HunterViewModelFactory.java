package com.headhunter.client.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class HunterViewModelFactory implements ViewModelProvider.Factory {

    private Application application;
    private int area;
    private String text;
    private int page;

    public HunterViewModelFactory(Application application, int area, String text, int page) {
        this.application = application;
        this.area = area;
        this.text = text;
        this.page = page;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HeadHunterViewModel(application, area, text, page);
    }
}
