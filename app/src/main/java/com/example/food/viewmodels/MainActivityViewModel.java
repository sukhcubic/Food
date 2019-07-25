package com.example.food.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.food.mediatore.FoodMediator;
import com.example.food.models.Food;

public class MainActivityViewModel extends ViewModel {

     private FoodMediator mRecipeRepository;
     private String mRecipeId;
     private boolean mDidRetrieveRecipe;

     public MainActivityViewModel() {
          mRecipeRepository = FoodMediator.getInstance();
          mDidRetrieveRecipe = false;
     }

     public LiveData<Food> getRecipe(){
          return mRecipeRepository.getRecipe();
     }

     public LiveData<Boolean> isRecipeRequestTimedOut(){
          return mRecipeRepository.isRecipeRequestTimedOut();
     }

     public void searchRecipeById(String recipeId){
          mRecipeId = recipeId;
          mRecipeRepository.searchRecipeById(recipeId);
     }

     public String getRecipeId() {
          return mRecipeId;
     }

     public void setRetrievedRecipe(boolean retrievedRecipe){
          mDidRetrieveRecipe = retrievedRecipe;
     }

     public boolean didRetrieveRecipe(){
          return mDidRetrieveRecipe;
     }

}
