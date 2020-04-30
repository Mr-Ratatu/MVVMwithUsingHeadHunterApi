package com.headhunter.client.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.headhunter.client.R;
import com.headhunter.client.adapter.FavouriteAdapter;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.databinding.FavouriteItemBinding;
import com.headhunter.client.databinding.FragmentFavouriteBinding;
import com.headhunter.client.databinding.FragmentMainBinding;
import com.headhunter.client.viewmodel.favourite.FavouriteFactory;
import com.headhunter.client.viewmodel.favourite.FavouriteViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouritesFragment extends Fragment {

    private FavouriteAdapter favouriteAdapter;
    private FavouriteViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFavouriteBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container, false);

        recyclerInitialize(binding.recyclerViewFavourite);
        viewModel = new ViewModelProvider(this, new FavouriteFactory(getActivity().getApplication())).get(FavouriteViewModel.class);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel.getListLiveData().observe(getViewLifecycleOwner(), itemHunters -> favouriteAdapter.submitList(itemHunters));

    }

    private void recyclerInitialize(RecyclerView recyclerView) {
        favouriteAdapter = new FavouriteAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(favouriteAdapter);
    }

}
