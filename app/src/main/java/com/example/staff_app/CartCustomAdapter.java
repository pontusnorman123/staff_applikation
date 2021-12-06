/*
package com.example.staff_app;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class CartCustomAdapter extends RecyclerView.Adapter<CartCustomAdapter.MyViewHolder> {

    Context context;

    CartCustomAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CartCustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.order_layout_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartCustomAdapter.MyViewHolder holder, int position) {
        holder.food = SF.s.getFoods().get(position);
        holder.name.setText(holder.food.getName());;
    }

    @Override
    public int getItemCount() {return SF.s.getFoods().size();}

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        Button buttonMinus;
        TextView counter;

        MenuItem food;
        int position;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // set view connections
            position = getAdapterPosition();
            name = itemView.findViewById(R.id.name);
            buttonMinus = itemView.findViewById(R.id.button_remove);
            counter = itemView.findViewById(R.id.foodCount);

            buttonMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test", "clicked " + getAdapterPosition());
                    food.decrementCounter();
                    counter.setText(String.valueOf(food.getCount()));
                }
            });
        }
    }
}
*/