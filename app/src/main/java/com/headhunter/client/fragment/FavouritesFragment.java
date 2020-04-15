package com.headhunter.client.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.headhunter.client.R;
import com.headhunter.client.adapter.FavouriteAdapter;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.viewmodel.FavouriteFactory;
import com.headhunter.client.viewmodel.FavouriteViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouritesFragment extends Fragment {

    private List<ItemHunter> list;
    private RecyclerView recyclerView;
    private FavouriteAdapter favouriteAdapter;
    private FavouriteViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        recyclerInitialize(view);
        viewModel = new ViewModelProvider(this, new FavouriteFactory(getActivity().getApplication())).get(FavouriteViewModel.class);
        viewModel.getListLiveData().observe(this, itemHunters -> favouriteAdapter.setList(itemHunters));

        return view;
    }

    private void recyclerInitialize(View view) {
        list = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler_view_favourite);
        favouriteAdapter = new FavouriteAdapter(list);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(favouriteAdapter);
    }
}
