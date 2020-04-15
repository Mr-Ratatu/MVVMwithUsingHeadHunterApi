package com.headhunter.client.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.headhunter.client.R;
import com.headhunter.client.adapter.HeadHunterAdapter;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.viewmodel.FavouriteFactory;
import com.headhunter.client.viewmodel.FavouriteViewModel;
import com.headhunter.client.viewmodel.HeadHunterViewModel;
import com.headhunter.client.viewmodel.HunterViewModelFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements HeadHunterAdapter.OnAdapterClickListener {

    private RecyclerView recyclerView;
    private HeadHunterAdapter headHunterAdapter;
    private ProgressBar downloadData;

    private HeadHunterViewModel headHunterViewModel;
    private FavouriteViewModel favouriteViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        initializeRecyclerView(view);

        favouriteViewModel = new ViewModelProvider(this,
                new FavouriteFactory(getActivity().getApplication())).get(FavouriteViewModel.class);

        headHunterViewModel = new ViewModelProvider(this, new HunterViewModelFactory(getActivity().getApplication(),
                1, "Android", 1)).get(HeadHunterViewModel.class);

        return view;
    }

    private void initializeRecyclerView(View view) {
        downloadData = view.findViewById(R.id.download_data);
        recyclerView = view.findViewById(R.id.recycler_view);

        headHunterAdapter = new HeadHunterAdapter(this);

        recyclerView.setAdapter(headHunterAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        headHunterViewModel.getPagedListLiveData().observe(this, new Observer<PagedList<ItemHunter>>() {
            @Override
            public void onChanged(PagedList<ItemHunter> itemHunters) {
                headHunterAdapter.submitList(itemHunters);
                visibilityData();
            }
        });
    }

    private void visibilityData() {
        downloadData.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClickAdapter(int position) {
        Navigation.findNavController(getView()).navigate(R.id.action_mainFragment_to_detailHeadHunterFragment);
    }

    @Override
    public void onClickFavourite(ItemHunter itemHunter, ImageView imageView) {
        List<ItemHunter> list = new ArrayList<>();
        list.add(itemHunter);
        imageView.setImageResource(R.drawable.ic_star_nav);
        favouriteViewModel.insert(list);
        Toast.makeText(getContext(), "Вакансия добавлена в избранное", Toast.LENGTH_SHORT).show();
    }
}
