package com.headhunter.client.data.network;

import com.headhunter.client.data.model.HeadHunterBody;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("vacancies")
    Call<HeadHunterBody> getVacancies(@Query("area") int area,
                                      @Query("text") String text,
                                      @Query("page") int page);
}
