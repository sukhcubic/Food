package com.example.food.network;


import com.example.food.models.Food;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodResponse {

    @SerializedName("food")
    @Expose()
    private Food food;

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "FoodResponse{" +
                "food=" + food +
                '}';
    }
}