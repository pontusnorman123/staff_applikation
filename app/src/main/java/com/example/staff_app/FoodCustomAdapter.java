package com.example.staff_app;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


// fills Recycler view with myViewHolders(which is the model of order_row_layout)

public class FoodCustomAdapter extends RecyclerView.Adapter<FoodCustomAdapter.MyViewHolder> {

    Context context;
    boolean isDrink;


    FoodCustomAdapter(Context context, boolean isDrink) {
        this.context = context;
        this.isDrink = isDrink;
    }


    @NonNull
    @Override
    public FoodCustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.order_layout_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodCustomAdapter.MyViewHolder holder, int position) {
        if(isDrink) {
            //holder.food = SF.s.getDrinks().get(position);
        } else {
            holder.food = SF.s.getFoods().get(position);
        }


        //Skriver ut maträtten
        holder.name.setText(holder.food.getName());
    }

    @Override
    public int getItemCount() {return SF.s.getFoods().size();}

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        Button buttonPlus;
        Button buttonMinus;
        TextView counter;
        Food food;

        int position;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            // set view connections
            position = getAdapterPosition();
            name = itemView.findViewById(R.id.name);
            buttonPlus = itemView.findViewById(R.id.button_add);
            buttonMinus = itemView.findViewById(R.id.button_remove);
            counter = itemView.findViewById(R.id.foodCount);


            //Ökar antalet(Fungerade + knapp)
            buttonPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test", "clicked " + getAdapterPosition());
                    food.incrementCounter();
                    //SF.s.incrementFoodAtPosition(getAdapterPosition());
                    counter.setText(String.valueOf(food.getCount()));
                }
            });

            //Minskar antalet(Fungerande - knapp)
            buttonMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test", "clicked " + getAdapterPosition());
                    food.decrementCounter();
                    //SF.s.incrementFoodAtPosition(getAdapterPosition());
                    counter.setText(String.valueOf(food.getCount()));
                }
            });
        }
    }

}
