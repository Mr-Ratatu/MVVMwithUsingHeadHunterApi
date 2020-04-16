package com.headhunter.client.viewmodel;

import android.app.Application;

import com.headhunter.client.data.model.ItemHunter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class FavouriteViewModel extends AndroidViewModel {

    private FavouriteRepository favouriteRepository;
    private LiveData<List<ItemHunter>> listLiveData;
    private LiveData<Integer> checkDB;

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

    public void insert(List<ItemHunter> itemHunterList) {
        favouriteRepository.insertHabit(itemHunterList);
    }

    public void delete(ItemHunter deleteItemHunter) {
        favouriteRepository.deleteHabit(deleteItemHunter);
    }
}
