package com.example.staff_app;

public class MenuItem {

    private final String name;
    private int counter = 0;
    private int price;
    //private int dishID;

    public MenuItem(String name){
        this.name = name;
    }
    public MenuItem(MenuItem m)
    {
        this.name = m.name;
        this.counter = m.counter;
        this.price = m.price;
        //this.id = m.id;
    }
    public void incrementCounter(){
        counter++;
    }
    public void decrementCounter(){
        if(counter > 0) { counter--; }
    }
    public void setCount(int count){this.counter = count;}


    public String getName() {return name;}
    public int getCount(){return counter;}
}
