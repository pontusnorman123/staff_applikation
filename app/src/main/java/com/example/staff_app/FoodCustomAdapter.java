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

public class FoodCustomAdapter extends RecyclerView.Adapter<FoodCustomAdapter.MyViewHolder> {

    Context context;
    private ArrayList<Food> foods;

    FoodCustomAdapter(Context context, ArrayList<Food> f) {
        this.context = context;
        foods = f;

    }
    public void add_f(Food food) {
        foods.add(food);
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
        Food food = foods.get(position);
        holder.name.setText(String.valueOf(food.getName()));
        holder.food = food;
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        Button finished_status;
        Food food;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}