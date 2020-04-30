package com.headhunter.client.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.headhunter.client.R;
import com.headhunter.client.adapter.HeadHunterAdapter;
import com.headhunter.client.binding.MainItemViewModel;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.databinding.FragmentMainBinding;
import com.headhunter.client.viewmodel.favourite.FavouriteFactory;
import com.headhunter.client.viewmodel.favourite.FavouriteViewModel;
import com.headhunter.client.viewmodel.main.HeadHunterViewModel;
import com.headhunter.client.viewmodel.main.HunterViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private HeadHunterAdapter headHunterAdapter;

    private HeadHunterViewModel headHunterViewModel;
    private FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        initializeRecyclerView(binding.recyclerView);

        //Отредактировать
        headHunterViewModel = new ViewModelProvider(this, new HunterViewModelFactory(getActivity().getApplication(),
                1, "android", 1)).get(HeadHunterViewModel.class);

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
