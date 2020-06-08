package com.headhunter.client.viewmodel.favourite;

import android.annotation.SuppressLint;
import android.content.Context;

import com.headhunter.client.data.db.HeadHunterDao;
import com.headhunter.client.data.db.HeadHunterDataBase;
import com.headhunter.client.data.model.ItemHunter;

import java.util.List;

import androidx.lifecycle.LiveData;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FavouriteRepository {

    private static FavouriteRepository INSTANCE;
    private HeadHunterDao headHunterDao;
    private CompositeDisposable compositeDisposable;

    public static FavouriteRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new FavouriteRepository(context);
        }

        return INSTANCE;
    }

    private FavouriteRepository(Context context) {
        headHunterDao = HeadHunterDataBase.getInstance(context).getHeadHunterDao();
        compositeDisposable = new CompositeDisposable();
    }

    public Observable<Integer> getCheckDB() {
        return headHunterDao.getCheckDB()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace);
    }

    @SuppressLint("CheckResult")
    public Observable<List<ItemHunter>> getListLiveData() {
        return headHunterDao.getAllFavouriteVacancy()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace);
    }

    public void insertHunter(ItemHunter itemHunters) {
        compositeDisposable.add(headHunterDao.insert(itemHunters)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .subscribe());
    }

    public void deleteHunter(ItemHunter itemHunter) {
        compositeDisposable.add(headHunterDao.delete(itemHunter)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .subscribe());
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }
}
