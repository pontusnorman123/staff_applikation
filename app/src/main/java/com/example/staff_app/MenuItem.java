package com.example.staff_app;

public class MenuItem {

    private String name;
    public int counter = 0;

    public MenuItem(String name){
        this.name = name;
    }

    public void incrementCounter(){
        counter++;
    }
    public void decrementCounter(){
        if(counter <= 0)
            return;
        else
            counter--;
    }
    
    public String getName() {return name;}
    public int getCount(){return counter;}
}
