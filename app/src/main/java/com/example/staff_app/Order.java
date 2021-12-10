package com.example.staff_app;

public class Order {

    private int tableNumber;
    private boolean delivered = false;

    public Order(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    public int getTableNumber() {
        return tableNumber;
    }

    public boolean isDelivered() {return delivered;}

    public void setDeliveredAs(boolean status) {
        this.delivered = status;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
