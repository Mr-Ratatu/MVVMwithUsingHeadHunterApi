package com.headhunter.client.viewmodel.item;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.headhunter.client.R;
import com.headhunter.client.databinding.HeadHunterItemBinding;
import com.headhunter.client.ui.adapter.HeadHunterAdapter;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.utils.Constant;
import com.headhunter.client.viewmodel.favourite.FavouriteRepository;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.navigation.Navigation;

public class MainItemViewModel extends BaseObservable {

    private FavouriteRepository favouriteRepository;
    private HeadHunterItemBinding binding;
    private ItemHunter itemHunter;
    private Context context;

    public MainItemViewModel(HeadHunterItemBinding binding, Context context, ItemHunter itemHunter) {
        this.binding = binding;
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
        binding.addToFavourite.setImageResource(R.drawable.ic_star_nav);
    }

    public void openTheDetailFragmentClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.ITEM, itemHunter.getId());

        Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_detailHeadHunterFragment, bundle);
    }

}
