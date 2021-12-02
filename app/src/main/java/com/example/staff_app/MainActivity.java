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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SF.s.clear();

        Food food = new Food("Fiskpinnar. Potatis");
        Food food2 = new Food("Ungsbakad Lax. Potatis");
        SF.s.addFood(food);
        SF.s.addFood(food2);

        Food drink = new Food("Coca Cola");
        Food drink2 = new Food("Fanta");


        RecyclerView recyclerFood = findViewById(R.id.recyclerFood);
        RecyclerView recyclerDrink = findViewById(R.id.recyclerDrink);

        // Foods
        SF.s.customAdapterFood = new FoodCustomAdapter(MainActivity.this, false);
        recyclerFood.setAdapter(SF.s.customAdapterFood);
        recyclerFood.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //Kod för att hämta bordsnummer från FrontPage
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            //The key argument here must match that used in the other activity
            TextView tableNr = (TextView) findViewById(R.id.tableNr);
            tableNr.setText(value);
        }

        // Drinks
//        SF.s.customAdapterDrink = new FoodCustomAdapter(MainActivity.this, true);
//        recyclerDrink.setAdapter(SF.s.customAdapterDrink);
//        recyclerDrink.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}
//    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {}
