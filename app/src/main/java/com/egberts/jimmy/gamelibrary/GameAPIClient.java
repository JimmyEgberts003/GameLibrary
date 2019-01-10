package com.egberts.jimmy.gamelibrary;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GameAPIClient {
    String BASE_URL = "https://www.giantbomb.com/api/";
    String API_KEY = "7726788a09df4f91fbdd544e96ade34a35bc189b";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("games")
    Call<Games> getGames(@Query("api_key") String key, @Query("format") String format, @Query("limit") Integer limit);
}
