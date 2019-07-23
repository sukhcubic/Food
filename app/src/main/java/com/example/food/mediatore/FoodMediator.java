package com.example.food.mediatore;

import com.example.food.network.FoodApiClient;

public class FoodMediator {

    private static FoodMediator instance;


        public static FoodMediator getInstance(){
        if(instance == null){
            instance = new FoodMediator();
        }
        return instance;
    }

    private FoodMediator(){
//        mRecipeApiClient = FoodApiClient.getInstance();
//        initMediators();
    }


}
