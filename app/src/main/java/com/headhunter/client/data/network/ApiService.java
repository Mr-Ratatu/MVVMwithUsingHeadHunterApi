package com.headhunter.client.data.network;

import com.headhunter.client.data.model.company.CompanyInfoBody;
import com.headhunter.client.data.model.detail.DetailModelBody;
import com.headhunter.client.data.network.responce.HeadHunterBody;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("vacancies")
    Observable<HeadHunterBody> getVacancies(@Query("area") int area,
                                            @Query("text") String text,
                                            @Query("page") long page);

    @GET("vacancies/{vacancies_id}")
    Observable<DetailModelBody> getIdVacancies(@Path("vacancies_id") String id);

    @GET("employers/{company_id}")
    Observable<CompanyInfoBody> getCompanyInfo(@Path("company_id") String id);
}
