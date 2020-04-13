package com.headhunter.client.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.headhunter.client.R;
import com.headhunter.client.adapter.HeadHunterAdapter;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.viewmodel.HeadHunterViewModel;
import com.headhunter.client.viewmodel.HunterViewModelFactory;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private HeadHunterAdapter headHunterAdapter;
    private HeadHunterViewModel headHunterViewModel;
    private ProgressBar downloadData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        downloadData = view.findViewById(R.id.download_data);
        recyclerView = view.findViewById(R.id.recycler_view);
        headHunterAdapter = new HeadHunterAdapter();

        recyclerView.setAdapter(headHunterAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        headHunterViewModel = new ViewModelProvider(this, new HunterViewModelFactory(getActivity().getApplication(),
                1, "Android", 1)).get(HeadHunterViewModel.class);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        headHunterViewModel.getMutableLiveData().observe(this, new Observer<List<ItemHunter>>() {
            @Override
            public void onChanged(List<ItemHunter> itemHunters) {
                List<ItemHunter> list = itemHunters;
                headHunterAdapter.setList(list);
                visibilityData();
            }
        });
    }

    private void visibilityData() {
        downloadData.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

}
