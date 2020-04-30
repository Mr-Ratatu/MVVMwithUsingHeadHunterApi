package com.headhunter.client.binding;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.headhunter.client.R;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.viewmodel.favourite.FavouriteRepository;

import androidx.databinding.BaseObservable;
import androidx.navigation.Navigation;

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
}
