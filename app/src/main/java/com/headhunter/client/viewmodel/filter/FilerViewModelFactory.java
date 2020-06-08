package com.headhunter.client.viewmodel.filter;

import com.headhunter.client.databinding.FragmentFilterVacancyBinding;
import com.headhunter.client.ui.fragment.FilterVacancyFragment;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class FilerViewModelFactory implements ViewModelProvider.Factory {

    private FragmentFilterVacancyBinding binding;
    private FilterVacancyFragment filterVacancyFragment;

    public FilerViewModelFactory(FragmentFilterVacancyBinding binding, FilterVacancyFragment filterVacancyFragment) {
        this.binding = binding;
        this.filterVacancyFragment = filterVacancyFragment;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new FilterViewModel(binding, filterVacancyFragment);
    }
}
