package com.headhunter.client.data.db;

import com.headhunter.client.data.model.ItemHunter;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface HeadHunterDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<ItemHunter> itemHunter);

    @Delete
    void delete(ItemHunter itemHunter);

    @Query("SELECT * FROM item_db")
    LiveData<List<ItemHunter>> getAllFavouriteVacancy();
}
