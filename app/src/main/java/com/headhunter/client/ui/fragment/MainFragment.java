package com.headhunter.client.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.headhunter.client.R;
import com.headhunter.client.ui.adapter.HeadHunterAdapter;
import com.headhunter.client.databinding.FragmentMainBinding;
import com.headhunter.client.viewmodel.main.HeadHunterViewModel;
import com.headhunter.client.viewmodel.main.HunterViewModelFactory;

public class MainFragment extends Fragment {

    private HeadHunterAdapter headHunterAdapter;

    private HeadHunterViewModel headHunterViewModel;
    private FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Поиск вакансий");
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        initializeRecyclerView(binding.recyclerView);

        //Отредактировать
        headHunterViewModel = new ViewModelProvider(this, new HunterViewModelFactory(getActivity().getApplication(),
                1, "android")).get(HeadHunterViewModel.class);

        binding.setViewModel(headHunterViewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        headHunterViewModel.getPagedListLiveData().observe(getViewLifecycleOwner(), itemHunters -> {
            headHunterAdapter.submitList(itemHunters);
        });

    }

    private void initializeRecyclerView(RecyclerView recyclerView) {
        headHunterAdapter = new HeadHunterAdapter();

        recyclerView.setAdapter(headHunterAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
