package com.example.food.util;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class Connectivity extends LiveData<Network> {

    private ConnectivityManager connectivityManager;

    private ConnectivityManager.NetworkCallback listener = new ConnectivityManager.NetworkCallback() {
        @Override
        public void onAvailable(Network network){
            postValue(network);
        }
        @Override
        public void onLost(Network network){
            postValue(network);
        }
    };

    public Connectivity(Context context) {
        connectivityManager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActive() {
        //onActive is called when there is an active observer to this LiveData
        //since active LiveData observers are there, add network callback listener to connectivity manager
        connectivityManager.registerDefaultNetworkCallback(listener);
    }

    @Override
    protected void onInactive() {
        //onActive is called when there is no active observer to this LiveData
        //as no active observers exist, remove netwrok callback from connectivity manager
        connectivityManager.unregisterNetworkCallback(listener);
    }
}
