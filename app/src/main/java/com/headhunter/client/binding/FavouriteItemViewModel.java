package com.headhunter.client.binding;

import android.content.Context;
import android.view.View;

import com.headhunter.client.R;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.viewmodel.favourite.FavouriteRepository;

import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.BaseObservable;

public class FavouriteItemViewModel extends BaseObservable {

    private FavouriteRepository favouriteRepository;
    private ItemHunter itemHunter;
    private Context context;

    public FavouriteItemViewModel(ItemHunter itemHunter, Context context) {
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

    public void deleteFromFavouriteClick(View view) {
        PopupMenu popup = new PopupMenu(context, view);
        popup.inflate(R.menu.settings_favourite);

        popup.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.delete_vacancy:
                    favouriteRepository.deleteHunter(itemHunter);
                    return true;

                default:
                    return false;
            }
        });

        popup.show();
    }

    public void setItemHunter(ItemHunter itemHunter) {
        this.itemHunter = itemHunter;
        notifyChange();
    }
}
