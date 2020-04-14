package com.headhunter.client.data.source;

import com.headhunter.client.data.model.HeadHunterBody;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.data.network.ApiFactory;
import com.headhunter.client.data.network.ApiService;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPositionalDataSource extends PageKeyedDataSource<Long, ItemHunter> {

    private ApiService apiService;

    private int area;
    private String text;
    private int page;

    public MyPositionalDataSource(int area, String text, int page) {
        this.area = area;
        this.text = text;
        this.page = page;
        apiService = ApiFactory.getInstance().getApiService();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull final LoadInitialCallback<Long, ItemHunter> callback) {
        apiService.getVacancies(area, text, page).enqueue(new Callback<HeadHunterBody>() {
            @Override
            public void onResponse(Call<HeadHunterBody> call, Response<HeadHunterBody> response) {
                List<ItemHunter> list = response.body().getItems();
                callback.onResult(list, null, (long) 2);
            }

            @Override
            public void onFailure(Call<HeadHunterBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, ItemHunter> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Long> params, @NonNull final LoadCallback<Long, ItemHunter> callback) {
        apiService.getVacancies(area, text, page).enqueue(new Callback<HeadHunterBody>() {
            @Override
            public void onResponse(Call<HeadHunterBody> call, Response<HeadHunterBody> response) {
                List<ItemHunter> list = response.body().getItems();
                callback.onResult(list, params.key + 1);
            }

            @Override
            public void onFailure(Call<HeadHunterBody> call, Throwable t) {

            }
        });
    }
}