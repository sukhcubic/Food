package com.example.food.network;

import com.example.food.models.Food;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodSearchResponse {
    @SerializedName("count")
    @Expose()
    private int count;

    @SerializedName("foods")
    @Expose()
    private List<Food> foods;

    public int getCount() {
        return count;
    }

    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public String toString() {
        return "FoodSearchResponse{" +
                "count=" + count +
                ", foods=" + foods +
                '}';
    }
}