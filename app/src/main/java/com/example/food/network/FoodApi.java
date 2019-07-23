package com.example.food.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodApi {
    @GET("api/search")
    Call<FoodSearchResponse> searchRecipe(
            @Query("key") String key,
            @Query("q") String query,
            @Query("page") String page
    );

    @GET("api/get")
    Call<FoodResponse> getRecipe(
            @Query("key") String key,
            @Query("rId") String recipe_id
    );
}
