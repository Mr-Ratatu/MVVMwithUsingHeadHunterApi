package com.headhunter.client.viewmodel.item;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.headhunter.client.R;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.utils.Constant;
import com.headhunter.client.viewmodel.favourite.FavouriteRepository;

import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.BaseObservable;
import androidx.navigation.Navigation;

public class FavouriteItemViewModel extends BaseObservable {

    private FavouriteRepository favouriteRepository;
    private ItemHunter itemHunter;

    public FavouriteItemViewModel(ItemHunter itemHunter, Context context) {
        this.itemHunter = itemHunter;

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

    public void deleteFromFavouriteClick(View view) {
        PopupMenu popup = new PopupMenu(view.getContext(), view);
        popup.inflate(R.menu.settings_favourite);

        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.delete_vacancy) {
                favouriteRepository.deleteHunter(itemHunter);
                return true;
            }
            return false;
        });

        popup.show();
    }

    public void openDetailFragmentClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.FAVOURITE_ITEM, itemHunter.getId());

        Navigation.findNavController(view).navigate(R.id.action_favouritesFragment_to_detailHeadHunterFragment, bundle);
    }

    public void setItemHunter(ItemHunter itemHunter) {
        this.itemHunter = itemHunter;
        notifyChange();
    }
}
