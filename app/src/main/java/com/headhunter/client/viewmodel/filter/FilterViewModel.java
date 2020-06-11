package com.headhunter.client.viewmodel.filter;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.headhunter.client.R;
import com.headhunter.client.databinding.FragmentFilterVacancyBinding;
import com.headhunter.client.ui.fragment.FilterVacancyFragment;
import com.headhunter.client.utils.Constant;

import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

public class FilterViewModel extends ViewModel {

    private FragmentFilterVacancyBinding binding;
    private FilterVacancyFragment filterVacancyFragment;

    public FilterViewModel(FragmentFilterVacancyBinding binding, FilterVacancyFragment filterVacancyFragment) {
        this.binding = binding;
        this.filterVacancyFragment = filterVacancyFragment;
    }

    private boolean checkFieldIsEmpty() {
        if (binding.titleVacancy.getEditText().getText().toString().trim().isEmpty()) {
            binding.titleVacancy.setError("Поле не может быть пустым");
            return false;
        }

        return true;
    }

    public void onSearchVacancyClick(View view) {
        if (!checkFieldIsEmpty()) {
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putString(Constant.VACANCY, binding.titleVacancy.getEditText().getText().toString().trim());

        Navigation.findNavController(view).navigate(R.id.action_filterVacancyFragment_to_mainFragment, bundle);
        filterVacancyFragment.hideTheKeyBoard(binding.titleVacancy.getEditText());
    }

}
