package com.example.staff_app;

import android.util.Log;

public class Food {

    private String name;
    private int counter = 0;

    public Food(String name){
        this.name = name;
    }

    public void incrementCounter() {
        counter = counter + 1;
        Log.d("Food", "counter incremented to: " + counter);
    }

    public int getCount() {return counter;}
    public String getName() {return name;}
}
