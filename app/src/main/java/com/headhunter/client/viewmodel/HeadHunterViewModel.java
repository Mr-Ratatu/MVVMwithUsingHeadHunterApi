package com.headhunter.client.viewmodel;

import android.app.Application;

import com.headhunter.client.data.model.ItemHunter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class HeadHunterViewModel extends AndroidViewModel {

    private HeadHunterRepository hunterRepository;
    private MutableLiveData<List<ItemHunter>> mutableLiveData;

    public HeadHunterViewModel(@NonNull Application application, int area, String text, int page) {
        super(application);

        hunterRepository = HeadHunterRepository.getInstance(application);
        mutableLiveData = hunterRepository.getItemHunter(area, text, page);
    }

    public MutableLiveData<List<ItemHunter>> getMutableLiveData() {
        return mutableLiveData;
    }
}
