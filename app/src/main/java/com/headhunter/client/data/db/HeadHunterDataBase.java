package com.headhunter.client.data.db;

import android.content.Context;

import com.headhunter.client.data.model.ItemHunter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ItemHunter.class}, version = 4, exportSchema = false)
public abstract class HeadHunterDataBase extends RoomDatabase {

    private static final String DB_NAME = "head_hunter";
    private static HeadHunterDataBase instance;

    public static HeadHunterDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (HeadHunterDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context,
                            HeadHunterDataBase.class, DB_NAME)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }

    public abstract HeadHunterDao getHeadHunterDao();
}
