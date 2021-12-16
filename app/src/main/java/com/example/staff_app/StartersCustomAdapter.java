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

public class StartersCustomAdapter extends RecyclerView.Adapter<StartersCustomAdapter.MyViewHolder> {

    Context context;

    StartersCustomAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public StartersCustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.food_layout_row, parent, false);
        return new StartersCustomAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StartersCustomAdapter.MyViewHolder holder, int position) {
        holder.food = SF.s.getStarter().get(position);
        holder.name.setText(holder.food.getName());
        holder.price.setText(holder.food.getPrice() + ";-");
    }

    @Override
    public int getItemCount() {return SF.s.getStarter().size();}

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView price;
        Button buttonPlus;


        MenuItem food;
        int position;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // set view connections
            position = getAdapterPosition();
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            buttonPlus = itemView.findViewById(R.id.button_add);


            buttonPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test", "clicked " + getAdapterPosition());
                    //counter.setText(String.valueOf(food.getCount()));
                    if(food.getCount() == 0) {
                        SF.s.addToCart(new MenuItem(food));
                        SF.s.setSumCart();
                    }
                }
            });

        }
    }
}
