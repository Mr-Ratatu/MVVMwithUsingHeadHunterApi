package com.headhunter.client.binding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.headhunter.client.R;
import com.headhunter.client.ui.adapter.HeadHunterAdapter;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.viewmodel.favourite.FavouriteRepository;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainItemViewModel extends BaseObservable {

    private FavouriteRepository favouriteRepository;
    private ItemHunter itemHunter;
    private Context context;

    public MainItemViewModel(Context context, ItemHunter itemHunter) {
        this.itemHunter = itemHunter;
        this.context = context;
        favouriteRepository = FavouriteRepository.getInstance(context);
    }

    public String getName() {
        return itemHunter.getName();
    }

    public String getEmployerName() {
        return itemHunter.getEmployer().getName();
    }

    public String getSnippetResponsibility() {
        return itemHunter.getSnippet().getResponsibility();
    }

    public String getAreaName() {
        return itemHunter.getArea().getAreaName();
    }

    public void addToFavouritesClick() {
        if (itemHunter.getSnippet().getResponsibility() == null) {
            itemHunter.getSnippet().setResponsibility("");
        }
        favouriteRepository.insertHunter(itemHunter);
        Toast.makeText(context, "Вакансия добавлена в избранное", Toast.LENGTH_SHORT).show();
    }

    public void openTheDetailFragmentClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_detailHeadHunterFragment);
    }

    @BindingAdapter("app:setAdapter")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setAdapter(new HeadHunterAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }
}
