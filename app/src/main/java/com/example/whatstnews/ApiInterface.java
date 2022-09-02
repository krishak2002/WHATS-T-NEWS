package com.example.whatstnews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String Base_Url="https://newsapi.org/v2/";
    @GET("top-headlines")
     Call<mainNews>getNews(

        @Query("country") String country,
         @Query("pagesize") int pagesize,
        @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<mainNews>getCategoryNews(

            @Query("country") String country,
            @Query("category")String category,
            @Query("pagesize") int pagesize,
            @Query("apiKey") String apiKey
    );
}
