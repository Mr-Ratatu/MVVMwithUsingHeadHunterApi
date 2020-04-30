package com.headhunter.client.viewmodel.favourite;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.headhunter.client.data.model.ItemHunter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class FavouriteViewModel extends AndroidViewModel {

    private FavouriteRepository favouriteRepository;
    private LiveData<List<ItemHunter>> listLiveData;
    private static LiveData<Integer> checkDB;

    public FavouriteViewModel(@NonNull Application application) {
        super(application);

        favouriteRepository = FavouriteRepository.getInstance(application);
        listLiveData = favouriteRepository.getListLiveData();
        checkDB = favouriteRepository.getCheckDB();
    }

    public LiveData<Integer> getCheckDB() {
        return checkDB;
    }

    public LiveData<List<ItemHunter>> getListLiveData() {
        return listLiveData;
    }

    /*@BindingAdapter("app:visibleText")
    public static void visibleText(TextView textView, Integer value) {
        if (value > 0) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
    }*/

}
