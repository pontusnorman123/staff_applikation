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


        //  add function `UpDateData` here and call `NotifyDataSetChanged`
        public void upDateData(ArrayList<Order> orders) {
            SO.s.orders.addAll(orders);
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
            holder.tableNumber.setText(String.valueOf(order.getTableNumber()));
            holder.name.setText(String.valueOf(order.getName()));
            holder.finished_status.setText(holder.BUTTON_NOT_DONE_TEXT);
            holder.order = order;
        }

        @Override
        public int getItemCount() {
            return SO.s.orders.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            // constants
            final String BUTTON_DONE_TEXT = "\u2713 Delivered";
            final String BUTTON_NOT_DONE_TEXT = "Not delivered";

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
                        if(order.isDelivered()) {
                            order.setDeliveredAs(false);
                            finished_status.setText(BUTTON_NOT_DONE_TEXT);
                        } else {
                            order.setDeliveredAs(true);
                            SO.s.removeOrder(getAdapterPosition());
                            finished_status.setText(BUTTON_DONE_TEXT);
                        }

                    }
                });
            }
        }
    }


