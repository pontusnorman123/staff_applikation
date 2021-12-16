
package com.example.staff_app;


import static java.lang.Character.toChars;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.util.TimeUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.concurrent.TimeUnit;


public class CartCustomAdapter extends RecyclerView.Adapter<CartCustomAdapter.MyViewHolder> {

    Context context;
    private final String COUNTER_VALUE_WHEN_ADDED = "1";

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
        Log.d("test", "clicked " + ": test");
        holder.item = SF.s.getCart().get(position);
        holder.name.setText(holder.item.getName());
        holder.counter.setText(COUNTER_VALUE_WHEN_ADDED);

        //holder.showNotes.setText(toChars(0x1_F4C5));
    }

    @Override
    public int getItemCount() {return SF.s.getCart().size();}

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        Button buttonMinus;
        Button buttonPlus;
        Button showNotes;
        TextView counter;

        MenuItem item;
        int position;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // set view connections
            position = getAdapterPosition();
            name = itemView.findViewById(R.id.name);
            buttonPlus = itemView.findViewById(R.id.button_add);
            buttonMinus = itemView.findViewById(R.id.button_remove);
            counter = itemView.findViewById(R.id.foodCount);
            showNotes = itemView.findViewById(R.id.show_notes);

            showNotes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(SF.s.customAdapterCart.context);

                    alert.setTitle("Set Note");
                    //alert.setMessage("Message");

                    // Set an EditText view to get user input
                    final EditText input = new EditText(SF.s.customAdapterCart.context);
                    alert.setView(input);
                    input.setText(item.getNotes());

                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            item.setNotes(input.getText().toString());
                            Log.d("test", input.getText().toString());
                        }
                    });

                    alert.show();
                }
            });

            buttonPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test", "clicked " + getAdapterPosition());
                    item.incrementCounter();
                    counter.setText(String.valueOf(item.getCount()));
                }
            });

            buttonMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test", "clicked " + getAdapterPosition());
                    if(item.getCount() > 1) {
                        item.decrementCounter();
                    }
                    else {
                        SF.s.removeFromCart(getAdapterPosition());
                        SF.s.setSumCart();
                    }
                    counter.setText(String.valueOf(item.getCount()));
                }
            });
        }
    }
}
