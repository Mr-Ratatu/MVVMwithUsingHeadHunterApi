package com.headhunter.client.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.headhunter.client.R;
import com.headhunter.client.databinding.FragmentFilterVacancyBinding;
import com.headhunter.client.viewmodel.filter.FilerViewModelFactory;
import com.headhunter.client.viewmodel.filter.FilterViewModel;

public class FilterVacancyFragment extends Fragment {

    private FilterViewModel filterViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFilterVacancyBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_filter_vacancy, container, false);

        filterViewModel = new ViewModelProvider(this, new FilerViewModelFactory(binding, this)).get(FilterViewModel.class);
        binding.setFilterViewModel(filterViewModel);

        return binding.getRoot();
    }

    public void hideTheKeyBoard(EditText myEditText) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);
    }
}