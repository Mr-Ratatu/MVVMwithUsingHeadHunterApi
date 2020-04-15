package com.headhunter.client.viewmodel;

import android.content.Context;

import com.headhunter.client.data.db.HeadHunterDao;
import com.headhunter.client.data.db.HeadHunterDataBase;
import com.headhunter.client.data.model.ItemHunter;

import java.util.List;

import androidx.lifecycle.LiveData;

class FavouriteRepository {

    private static FavouriteRepository INSTANCE;
    private HeadHunterDao headHunterDao;
    private LiveData<List<ItemHunter>> listLiveData;

    static FavouriteRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new FavouriteRepository(context);
        }

        return INSTANCE;
    }

    private FavouriteRepository(Context context) {
        headHunterDao = HeadHunterDataBase.getInstance(context).getHeadHunterDao();
        listLiveData = headHunterDao.getAllFavouriteVacancy();
    }

    LiveData<List<ItemHunter>> getListLiveData() {
        return listLiveData;
    }

    void insertHabit(final List<ItemHunter> itemHunters) {
        HeadHunterDataBase.databaseWriteExecutor.execute(() -> {
            headHunterDao.insert(itemHunters);
        });
    }

    void deleteHabit(ItemHunter itemHunter) {
        HeadHunterDataBase.databaseWriteExecutor.execute(() -> {
            headHunterDao.delete(itemHunter);
        });
    }
}
