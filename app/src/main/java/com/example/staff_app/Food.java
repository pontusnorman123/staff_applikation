package com.example.staff_app;

public class Food {

    private String name;
    public int counter = 0;

    public Food(String name){
        this.name = name;
    }

    public void AddCount(){
        counter++;


    }

    public String getName() {return name;}
    //public int getCount(){return counter;}
}
