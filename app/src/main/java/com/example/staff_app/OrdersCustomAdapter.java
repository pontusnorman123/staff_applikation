package com.example.staff_app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


// fills Recycler view with myViewHolders(which is the model of order_row_layout)

    public class OrdersCustomAdapter extends RecyclerView.Adapter<OrdersCustomAdapter.MyViewHolder> {

        Context context;

        OrdersCustomAdapter(Context context) {
            this.context = context;
        }

//    public void addAll(ArrayList<Order> orders) {
//        this.orders.addAll(orders);
//    }
//
//    public int add(Order order) {
//        return this.orders.add(order);
//    }

        //  add function `UpDateData` here and call `NotifyDataSetChanged`
        public void upDateData(ArrayList<Order> orders) {
            SO.s.orders.addAll(orders);
            //notifyDataSetChanged();
            notifyItemRangeInserted(SO.s.orders.size()-orders.size(), SO.s.orders.size());
        }

        @NonNull
        @Override
        public OrdersCustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.undelivered_orders_row, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull OrdersCustomAdapter.MyViewHolder holder, int position) {
            Order order = SO.s.orders.get(position);
            holder.tableNumber.setText(String.valueOf(order.getTablePrio()));
            holder.name.setText(String.valueOf(order.getName()));
            holder.time.setText(String.valueOf(order.getTime()));
            holder.finished_status.setText(holder.BUTTON_NOT_DONE_TEXT);
            holder.order = order;
        }

        @Override
        public int getItemCount() {
            return SO.s.orders.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            // constants
            final String BUTTON_DONE_TEXT = "\u2713 done";
            final String BUTTON_NOT_DONE_TEXT = "not done";

            // internal variables
            TextView tableNumber, name, time;
            Button finished_status;
            Order order;

            public MyViewHolder(@NonNull View itemView) {

                super(itemView);
                tableNumber = itemView.findViewById(R.id.tableNumber);
                name = itemView.findViewById(R.id.name);
                time = itemView.findViewById(R.id.time);
                //finished_status = itemView.findViewById(R.id.finished_status);

                finished_status = itemView.findViewById(R.id.finished_status);

                finished_status.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Order temp = SO.s.orders.get(getAdapterPosition());
                        if(order.isDone()) {
                            order.setDoneAs(false);
                            finished_status.setText(BUTTON_NOT_DONE_TEXT);
                        } else {
                            order.setDoneAs(true);
                            finished_status.setText(BUTTON_DONE_TEXT);
                        }

                        //SO.s.addOrders(new ArrayList<Order>());

                        //get(getAdapterPosition()).setTime(order.getTime()+1);
                        // create new identical order
                        //ArrayList<Order> orders = new ArrayList<Order>();
                        //orders.add(order);
                        //SO.s.addOrders(orders);
                    }
                });
            }
        }
    }


