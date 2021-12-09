package com.example.staff_app;

import androidx.recyclerview.widget.SortedList;

import java.util.ArrayList;

public class SO {
    // singleton class for orders
    public static SO s = new SO();

    OrdersCustomAdapter customAdapter;

    public final SortedList<Order> orders = new SortedList<>(Order.class, new SortedList.Callback<Order>() {
        @Override
        public void onInserted(int position, int count) {
            // put x2 if same
        }
        @Override
        public void onRemoved(int position, int count) {

        }
        @Override
        public void onMoved(int fromPosition, int toPosition) {

        }
        @Override
        public int compare(Order o1, Order o2) {
            if (o1.getTablePrio() > o2.getTablePrio()) { return 1; }
            else if (o1.getTablePrio() < o2.getTablePrio()) { return -1; }
            else {
                return Integer.compare(o2.getTime(), o1.getTime());
            }
        }
        @Override
        public void onChanged(int position, int count) {

        }
        @Override
        public boolean areContentsTheSame(Order oldItem, Order newItem) {
            return false;
        }
        @Override
        public boolean areItemsTheSame(Order item1, Order item2) {
            return false;
        }
    });

    public void addOrders(ArrayList<Order> o) {
        orders.addAll(o);
        customAdapter.notifyDataSetChanged();
        //customAdapter.notifyItemRangeChanged();
        //customAdapter.upDateData(orders);
    }

    public void addOrder() {
        //orders.addAll(orders);
        customAdapter.notifyDataSetChanged();
    }

//    SortedList<Order> deleteOrder() {
//
//    }





    private SO() {
    }
}
