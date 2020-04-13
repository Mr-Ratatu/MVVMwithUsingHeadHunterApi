package com.headhunter.client.viewmodel;

import android.content.Context;
import android.widget.Toast;

import com.headhunter.client.data.model.HeadHunterBody;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.data.network.ApiFactory;
import com.headhunter.client.data.network.ApiService;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class HeadHunterRepository {

    private static HeadHunterRepository hunterRepository;
    private ApiService apiService;
    private Context context;

    public static HeadHunterRepository getInstance(Context context) {
        if (hunterRepository == null) {
            hunterRepository = new HeadHunterRepository(context);
        }

        return hunterRepository;
    }

    private HeadHunterRepository(Context context) {
        apiService = ApiFactory.getInstance().getApiService();
        this.context = context;

    }

    MutableLiveData<List<ItemHunter>> getItemHunter(int area, String text, int page) {
        final MutableLiveData<List<ItemHunter>> liveData = new MutableLiveData<>();

        apiService.getVacancies(area, text, page)
                .enqueue(new Callback<HeadHunterBody>() {
                    @Override
                    public void onResponse(Call<HeadHunterBody> call, Response<HeadHunterBody> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            liveData.setValue(response.body().getItems());
                        }
                    }

                    @Override
                    public void onFailure(Call<HeadHunterBody> call, Throwable t) {
                        Toast.makeText(context, "Соединение с интернетом отсутствует", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });

        return liveData;
    }

}
