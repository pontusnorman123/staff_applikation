package com.example.staff_app;

public class Food {

    private String name;
    private int counter = 0;

    public Food(String name){
        this.name = name;
    }

    public void incrementCounter() {counter++; }

    public int getCount() {return counter;}
    public String getName() {return name;}
}
