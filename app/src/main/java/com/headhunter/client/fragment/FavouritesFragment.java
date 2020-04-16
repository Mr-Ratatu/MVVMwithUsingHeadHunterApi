package com.headhunter.client.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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
import com.headhunter.client.viewmodel.FavouriteFactory;
import com.headhunter.client.viewmodel.FavouriteViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouritesFragment extends Fragment implements FavouriteAdapter.OnFavouriteClickListener {

    private RecyclerView recyclerView;
    private FavouriteAdapter favouriteAdapter;
    private FavouriteViewModel viewModel;

    private TextView infoText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        infoText = view.findViewById(R.id.info_text);

        recyclerInitialize(view);
        viewModel = new ViewModelProvider(this, new FavouriteFactory(getActivity().getApplication())).get(FavouriteViewModel.class);
        viewModel.getListLiveData().observe(this, itemHunters -> favouriteAdapter.submitList(itemHunters));

        viewModel.getCheckDB().observe(this, this::checkingForEmptinessRoom);

        return view;
    }

    private void recyclerInitialize(View view) {
        recyclerView = view.findViewById(R.id.recycler_view_favourite);
        favouriteAdapter = new FavouriteAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(favouriteAdapter);
    }

    private void checkingForEmptinessRoom(Integer hhDB) {
        if (hhDB > 0) {
            infoText.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            infoText.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClickSettingsFavourite(ItemHunter itemHunter, View view) {
        PopupMenu popup = new PopupMenu(getContext(), view);
        popup.inflate(R.menu.settings_favourite);

        popup.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.delete_vacancy:
                    viewModel.delete(itemHunter);
                    return true;

                default:
                    return false;
            }
        });

        popup.show();
    }
}
