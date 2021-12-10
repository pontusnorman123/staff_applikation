package com.example.staff_app;

import androidx.recyclerview.widget.SortedList;

import java.util.ArrayList;

public class SO {
    // singleton class for orders
    public static SO s = new SO();

    OrdersCustomAdapter customAdapter;

    ArrayList<Order> orders = new ArrayList<>();

    public void resetAll() {
        orders = new ArrayList<>();

    }


    public void addOrders(ArrayList<Order> o) {
        orders.addAll(o);
        customAdapter.notifyDataSetChanged();

    }

    public void addOrder(Order o) {
        orders.add(o);

    }

    public void removeOrder(int pos) {
        // när det finns 0 kvar, kallar vi för att radera från SF
        if(pos < 0)
            return;
        orders.remove(pos);

        customAdapter.notifyItemRemoved(pos);
    }

    private SO() {
    }
}
