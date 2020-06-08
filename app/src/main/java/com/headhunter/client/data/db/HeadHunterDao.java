package com.headhunter.client.data.db;

import com.headhunter.client.data.model.ItemHunter;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;

@Dao
public interface HeadHunterDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insert(ItemHunter itemHunter);

    @Delete
    Completable delete(ItemHunter itemHunter);

    @Query("SELECT * FROM item_db")
    Observable<List<ItemHunter>> getAllFavouriteVacancy();

    @Query("SELECT COUNT(*) FROM item_db")
    Observable<Integer> getCheckDB();

}
