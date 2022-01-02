package com.example.staff_app;

public class Order {

    private int tableNumber;
    private boolean delivered = false;
    private int kitchenid;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    private String timestamp;

    public int getKitchenid() {
        return kitchenid;
    }

    public void setKitchenid(int kitchenid) {
        this.kitchenid = kitchenid;
    }

    public int getResturangid() {
        return resturangid;
    }

    public void setResturangid(int resturangid) {
        this.resturangid = resturangid;
    }

    private int resturangid;

    public Order(int tableNumber, int kitchenid, int resturangid, String timestamp) {
        this.tableNumber = tableNumber;
        this.kitchenid = kitchenid;
        this.resturangid = resturangid;
        this.timestamp = timestamp;
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
