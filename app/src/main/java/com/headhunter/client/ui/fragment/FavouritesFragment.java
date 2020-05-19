package com.headhunter.client.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.headhunter.client.R;
import com.headhunter.client.ui.adapter.FavouriteAdapter;
import com.headhunter.client.databinding.FragmentFavouriteBinding;
import com.headhunter.client.viewmodel.favourite.FavouriteFactory;
import com.headhunter.client.viewmodel.favourite.FavouriteViewModel;


public class FavouritesFragment extends Fragment {

    private FavouriteAdapter favouriteAdapter;
    private FavouriteViewModel viewModel;
    private FragmentFavouriteBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container, false);

        recyclerInitialize(binding.recyclerViewFavourite);
        viewModel = new ViewModelProvider(this, new FavouriteFactory(getActivity().getApplication())).get(FavouriteViewModel.class);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel.getListLiveData().observe(getViewLifecycleOwner(), itemHunters -> favouriteAdapter.submitList(itemHunters));
        viewModel.getCheckDB().observe(getViewLifecycleOwner(), this::checkOnEmptyDataBase);

    }

    private void checkOnEmptyDataBase(Integer value) {
        if (value == 0) {
            binding.infoText.setVisibility(View.VISIBLE);
        } else {
            binding.infoText.setVisibility(View.GONE);
        }
    }

    private void recyclerInitialize(RecyclerView recyclerView) {
        favouriteAdapter = new FavouriteAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(favouriteAdapter);
    }

}
