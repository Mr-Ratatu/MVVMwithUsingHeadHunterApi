package com.headhunter.client.viewmodel.favourite;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.headhunter.client.data.model.ItemHunter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class FavouriteViewModel extends AndroidViewModel {

    private FavouriteRepository favouriteRepository;
    private CompositeDisposable compositeDisposable;

    public FavouriteViewModel(@NonNull Application application) {
        super(application);

        favouriteRepository = FavouriteRepository.getInstance(application);
        compositeDisposable = favouriteRepository.getCompositeDisposable();
    }

    public Observable<Integer> getCheckDB() {
        return favouriteRepository.getCheckDB();
    }

    public Observable<List<ItemHunter>> getListLiveData() {
        return favouriteRepository.getListLiveData();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

}
