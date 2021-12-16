package com.example.staff_app;

public class MenuItem {

    private final String name;
    private int counter = 0;
    private int price;
    private int dishID;
    private String notes = "";

    public MenuItem(String name, int price){

        this.name = name;
        this.price = price;
    }

    public MenuItem(String name, int id, int price){
        this.name = name;
        this.dishID = id;
        this.price = price;
    }

    public MenuItem(MenuItem m)
    {
        this.name = m.name;
        this.counter = m.counter;
        this.price = m.price;
        this.dishID = m.dishID;
    }
    public void incrementCounter(){
        counter++;
    }
    public void decrementCounter(){
        if(counter > 0) { counter--; }
    }
    public void setCount(int count){this.counter = count;}
    public void setNotes(String notes) {this.notes = notes;}


    public String getName() {return name;}
    public int getCount(){return counter;}
    public int getDishID(){return dishID;}
    public String getNotes() {return notes; }
    public int getPrice(){return price;}
}
