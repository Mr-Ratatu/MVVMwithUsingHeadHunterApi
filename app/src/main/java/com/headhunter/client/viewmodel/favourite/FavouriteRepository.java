package com.headhunter.client.viewmodel.favourite;

import android.content.Context;

import com.headhunter.client.data.db.HeadHunterDao;
import com.headhunter.client.data.db.HeadHunterDataBase;
import com.headhunter.client.data.model.ItemHunter;

import java.util.List;

import androidx.lifecycle.LiveData;

public class FavouriteRepository {

    private static FavouriteRepository INSTANCE;
    private HeadHunterDao headHunterDao;
    private LiveData<List<ItemHunter>> listLiveData;
    private LiveData<Integer> checkDB;

    public static FavouriteRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new FavouriteRepository(context);
        }

        return INSTANCE;
    }

    private FavouriteRepository(Context context) {
        headHunterDao = HeadHunterDataBase.getInstance(context).getHeadHunterDao();
        listLiveData = headHunterDao.getAllFavouriteVacancy();
        checkDB = headHunterDao.getCheckDB();
    }

    public LiveData<Integer> getCheckDB() {
        return checkDB;
    }

    LiveData<List<ItemHunter>> getListLiveData() {
        return listLiveData;
    }

    public void insertHunter(final ItemHunter itemHunters) {
        HeadHunterDataBase.databaseWriteExecutor.execute(() -> headHunterDao.insert(itemHunters));
    }

    public void deleteHunter(ItemHunter itemHunter) {
        HeadHunterDataBase.databaseWriteExecutor.execute(() -> {
            headHunterDao.delete(itemHunter);
        });
    }
}
