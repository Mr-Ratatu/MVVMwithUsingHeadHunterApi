package com.headhunter.client.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.headhunter.client.R;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.data.model.detail.DetailModelBody;
import com.headhunter.client.data.network.responce.HeadHunterBody;
import com.headhunter.client.databinding.FragmentDetailHeadHunterBinding;
import com.headhunter.client.utils.Constant;
import com.headhunter.client.viewmodel.detail.DetailViewModel;
import com.headhunter.client.viewmodel.detail.DetailViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailHeadHunterFragment extends Fragment {

    private DetailViewModel detailViewModel;
    private FragmentDetailHeadHunterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_detail_head_hunter, container, false);


        detailViewModel = new ViewModelProvider(this, new DetailViewModelFactory(getDetailId())).get(DetailViewModel.class);
        binding.setViewModel(detailViewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        detailViewModel.getHeadHunterBodyLiveData().observe(getViewLifecycleOwner(),
                detailModelBody -> binding.setDetailModel(detailModelBody));

    }

    private String getDetailId() {
        String id;

        if (getArguments().getString(Constant.FAVOURITE_ITEM) != null) {
            id = getArguments().getString(Constant.FAVOURITE_ITEM);
        } else {
            id = getArguments().getString(Constant.ITEM);
        }

        return id;
    }
}
