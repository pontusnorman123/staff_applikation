package com.example.staff_app;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class SO {
    // singleton class for orders
    public static SO s = new SO();

    Random rand = new Random();

    OrdersCustomAdapter customAdapter;

    TextView numberOfOrders;

    ArrayList<Order> orders = new ArrayList<>();

    public void updateOrderNumberInFrontPage() {
        numberOfOrders.setText(String.valueOf(orders.size()));
    }

    public void resetAll() {
        orders = new ArrayList<>();
        updateOrderNumberInFrontPage();
    }

    public void addOrders(ArrayList<Order> o) {
        int oldSize = orders.size();
        orders.addAll(o);
        customAdapter.notifyItemRangeInserted(oldSize, orders.size());
        updateOrderNumberInFrontPage();
    }

    public void addOrder(Order o) {
        orders.add(o);
        if(customAdapter != null) {
            customAdapter.notifyItemInserted(orders.size()-1);
        }
        updateOrderNumberInFrontPage();
    }

    public void removeOrder(int pos) {
        // när det finns 0 kvar, kallar vi för att radera från SF
        if(pos < 0)
            return;
        orders.remove(pos);
        customAdapter.notifyItemRemoved(pos);
        updateOrderNumberInFrontPage();
    }

    public void databaseLoad() {

    }

    public void fakeLoad() {
        if(orders.size() < 8) {
            int testTableNumber = rand.nextInt(7) + 1;
            addOrder(new Order(testTableNumber));
            addOrder(new Order(testTableNumber));
        }
    }

    private SO() {
    }
}
