package com.headhunter.client.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.headhunter.client.R;
import com.headhunter.client.data.model.company.CompanyInfoBody;
import com.headhunter.client.databinding.FragmentCompanyDetailInfoFramgnetBinding;
import com.headhunter.client.utils.Constant;
import com.headhunter.client.viewmodel.company.CompanyDetailViewModel;
import com.headhunter.client.viewmodel.company.CompanyInfoFactory;

public class CompanyDetailInfoFragment extends Fragment {

    private CompanyDetailViewModel companyDetailViewModel;
    private FragmentCompanyDetailInfoFramgnetBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_company_detail_info_framgnet, container, false);

        companyDetailViewModel = new ViewModelProvider(this,
                new CompanyInfoFactory(getArguments().getString(Constant.ID_COMPANY))).get(CompanyDetailViewModel.class);

        binding.setViewModel(companyDetailViewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        companyDetailViewModel.getInfoLiveData().observe(getViewLifecycleOwner(),
                companyInfoBody -> binding.setCompanyDetail(companyInfoBody));
    }
}