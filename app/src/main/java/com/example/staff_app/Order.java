package com.example.staff_app;

public class Order {

    private int tableNumber;
    private String name;
    private boolean delivered = false;

    public Order(int tablePrio, String name, int time) {
        this.tableNumber = tablePrio;
        this.name = name;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public String getName() {
        return name;
    }
    public boolean isDelivered() {return delivered;}

    public void setName(String name){this.name = name;}

    public void setDeliveredAs(boolean status) {
        this.delivered = status;
    }
}
