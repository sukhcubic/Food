package com.example.food.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorServices {
    private static ExecutorServices instance;

    public static ExecutorServices getInstance(){
        if(instance == null){
            instance = new ExecutorServices();
        }
        return instance;
    }

    private final ScheduledExecutorService newtworkIO = Executors.newScheduledThreadPool(3);

    public ScheduledExecutorService networkIO(){
        return newtworkIO;
    }
}
