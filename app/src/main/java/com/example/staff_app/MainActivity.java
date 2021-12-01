package com.example.staff_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private Spinner spinner;
    private static final String[] paths = {"1", "2","3","4","5","6","7",};
//    FoodCustomAdapter customAdapterFood;
//    FoodCustomAdapter customAdapterDrink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Food food = new Food("Fiskpinnar. Potatis");
        Food food2 = new Food("Ungsbakad Lax. Potatis");
        SF.s.addFood(food);
        SF.s.addFood(food2);

        Food drink = new Food("Coca Cola");
        Food drink2 = new Food("Fanta");
        SF.s.addDrink(drink);
        SF.s.addDrink(drink2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.table_nr_dropdown);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        RecyclerView recyclerFood = findViewById(R.id.recyclerFood);
        RecyclerView recyclerDrink = findViewById(R.id.recyclerDrink);

        // Dishesfoods
        SF.s.customAdapterFood = new FoodCustomAdapter(MainActivity.this);
        recyclerFood.setAdapter(SF.s.customAdapterFood);
        recyclerFood.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // Drinks
        SF.s.customAdapterDrink = new FoodCustomAdapter(MainActivity.this);
        recyclerDrink.setAdapter(SF.s.customAdapterDrink);
        recyclerDrink.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
//    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {}
//    public void add_item(View view) {
//
//        TextView text = (TextView) findViewById(R.id.foodCount);
//        count++;
//        text.setText("" + count);
//    }
//
//    public void remove_item(View view) {
//
//        if(count <= 0 ) {
//            return;
//        }
//        count--;
//        TextView text = (TextView) findViewById(R.id.foodCount);
//        text.setText("" + count);
//    }
}

