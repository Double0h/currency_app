package com.example.android.doviz;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/api/latest?access_key=d7258702e77d17dd87a259f961f55fa9&symbols=USD,TRY,GBP&format=1")
    Call<info> getInfos();
}
