package com.example.staff_app;

public class Food {

    private int tableNumber;
    private String name;

    public Food(int tableNumber, String name){
        this.tableNumber = tableNumber;
        this.name = name;
    }
    public int getTableNumber() {return tableNumber;}
    public String getName() {return name;}
}
