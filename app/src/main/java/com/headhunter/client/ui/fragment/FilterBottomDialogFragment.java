package com.headhunter.client.ui.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.headhunter.client.R;
import com.headhunter.client.databinding.FragmentFiltrBottomDialogBinding;
import com.headhunter.client.utils.Constant;

public class FilterBottomDialogFragment extends BottomSheetDialogFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentFiltrBottomDialogBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_filtr_bottom_dialog, container, false);

        binding.searchVacancy.setOnClickListener(view -> {
            MainFragment mainFragment = new MainFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constant.VACANCY, binding.textInputLayout.getEditText().getText().toString().trim());
            mainFragment.setArguments(bundle);
            dismiss();
        });

        return binding.getRoot();
    }
}