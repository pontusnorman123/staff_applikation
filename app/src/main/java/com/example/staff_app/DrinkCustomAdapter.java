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


// fills Recycler view with myViewHolders(which is the model of order_row_layout)

public class DrinkCustomAdapter extends RecyclerView.Adapter<DrinkCustomAdapter.MyViewHolder> {

    Context context;

    DrinkCustomAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DrinkCustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.food_layout_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkCustomAdapter.MyViewHolder holder, int position) {
        holder.drink = SF.s.getDrinks().get(position);
        holder.name.setText(holder.drink.getName());;
    }

    @Override
    public int getItemCount() {return SF.s.getDrinks().size();}

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        Button buttonPlus;
        //Button buttonMinus;
        //TextView counter;

        MenuItem drink;
        int position;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // set view connections
            position = getAdapterPosition();
            name = itemView.findViewById(R.id.name);
            buttonPlus = itemView.findViewById(R.id.button_add);
           // buttonMinus = itemView.findViewById(R.id.button_remove);
            //counter = itemView.findViewById(R.id.foodCount);

            // set values of views
//           name.setText(food.getName());
//            counter.setText(food.getCount());

            buttonPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test", "clicked " + getAdapterPosition());

                    //counter.setText(String.valueOf(food.getCount()));
                    if(drink.getCount() == 0) {
                        SF.s.addToCart(new MenuItem(drink));
                    }
                }
            });

            /*
            buttonMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test", "clicked " + getAdapterPosition());
                    drink.decrementCounter();
                    //SF.s.incrementFoodAtPosition(getAdapterPosition());
                    counter.setText(String.valueOf(drink.getCount()));
                }
            });
            */
        }
    }
}
