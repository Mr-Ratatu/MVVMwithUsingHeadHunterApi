package com.headhunter.client.viewmodel.main;

import android.app.Application;

import com.headhunter.client.ui.fragment.MainFragment;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class HunterViewModelFactory implements ViewModelProvider.Factory {

    private Application application;
    private int area;
    private String text;

    public HunterViewModelFactory(Application application, int area, String text) {
        this.application = application;
        this.area = area;
        this.text = text;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HeadHunterViewModel(application, area, text);
    }
}
