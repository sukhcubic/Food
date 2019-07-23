package com.example.food.network;


import com.example.food.models.Recipe;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodResponse {

    @SerializedName("recipe")
    @Expose()
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "FoodResponse{" +
                "recipe=" + recipe +
                '}';
    }
}