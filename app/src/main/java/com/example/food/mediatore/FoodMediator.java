package com.example.food.mediatore;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.example.food.models.Food;
import com.example.food.network.FoodApiClient;

import java.util.List;

public class FoodMediator {

    private static FoodMediator instance;
    private FoodApiClient apiClient;
    private String mQuery;
    private int mPageNumber;
    private MutableLiveData<Boolean> mIsQueryExhausted = new MutableLiveData<>();
    private MediatorLiveData<List<Food>> mRecipes = new MediatorLiveData<>();

    public static FoodMediator getInstance(){
        if(instance == null){
            instance = new FoodMediator();
        }
        return instance;
    }

    private FoodMediator(){
        apiClient = FoodApiClient.getInstance();
        initMediators();
    }

    private void initMediators() {
        LiveData<List<Food>> recipeListApiSource = apiClient.getRecipes();
        mRecipes.addSource(recipeListApiSource, new Observer<List<Food>>() {
            @Override
            public void onChanged(@Nullable List<Food> foods) {
                if(foods != null){
                    mRecipes.setValue(foods);
                    doneQuery(foods);
                }else{
                }
            }
        });
    }

    private void doneQuery(List<Food> list){
        if(list != null){
            if (list.size() % 30 != 0) {
                mIsQueryExhausted.setValue(true);
            }
        }
        else{
            mIsQueryExhausted.setValue(true);
        }
    }

    public LiveData<Boolean> isQueryExhausted(){
        return mIsQueryExhausted;
    }

    public void searchNextPage(){
        searchRecipesApi(mQuery, mPageNumber + 1);
    }

    public void searchRecipeById(String recipeId){
        apiClient.searchRecipeById(recipeId);
    }

    public LiveData<List<Food>> getRecipes(){
        return mRecipes;
    }

    public LiveData<Food> getRecipe(){
        return apiClient.getRecipe();
    }

    public void searchRecipesApi(String query, int pageNumber){
        if(pageNumber == 0){
            pageNumber = 1;
        }
        mQuery = query;
        mPageNumber = pageNumber;
        mIsQueryExhausted.setValue(false);
        apiClient.searchRecipesApi(query, pageNumber);
    }

    public void cancelRequest(){
        apiClient.cancelRequest();
    }

    public LiveData<Boolean> isRecipeRequestTimedOut(){
        return apiClient.isRecipeRequestTimedOut();
    }

}
