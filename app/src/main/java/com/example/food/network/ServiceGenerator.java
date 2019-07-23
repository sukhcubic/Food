package com.example.food.network;

import com.example.food.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();
    private static FoodApi foodApi = retrofit.create(FoodApi.class);

    public static FoodApi getFoodApi(){
        return foodApi;
    }

}
