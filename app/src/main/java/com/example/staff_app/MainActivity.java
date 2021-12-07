package com.example.staff_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set menu items (from dish in DB)
        SF.s.resetAll();
        MenuItem food = new MenuItem("Fiskpinnar. Potatis");
        MenuItem food2 = new MenuItem("Ungsbakad Lax. Potatis");
        SF.s.addFood(food);
        SF.s.addFood(food2);

        SF.s.addFood(new MenuItem("McDonald's from next door"));
        SF.s.addFood(new MenuItem("kyckling sushi"));
        SF.s.addFood(new MenuItem("1 raw potato"));

        MenuItem drink = new MenuItem("Coca Cola");
        MenuItem drink2 = new MenuItem("Fanta");
        SF.s.addDrink(drink);
        SF.s.addDrink(drink2);

        //private int count = 0;

        RecyclerView recyclerFood = findViewById(R.id.recyclerFood);
        RecyclerView recyclerDrink = findViewById(R.id.recyclerDrink);
        RecyclerView recyclerCart = findViewById(R.id.recyclerViewCart);

        // Foods
        SF.s.customAdapterFood = new FoodCustomAdapter(MainActivity.this);
        recyclerFood.setAdapter(SF.s.customAdapterFood);
        recyclerFood.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // Drinks
        SF.s.customAdapterDrink = new DrinkCustomAdapter(MainActivity.this);
        recyclerDrink.setAdapter(SF.s.customAdapterDrink);
        recyclerDrink.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // Cart
        SF.s.customAdapterCart = new CartCustomAdapter(MainActivity.this);
        recyclerCart.setAdapter(SF.s.customAdapterCart);
        recyclerCart.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //Kod för att hämta bordsnummer från FrontPage
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            //The key argument here must match that used in the other activity
            TextView tableNr = (TextView) findViewById(R.id.tableNr);
            tableNr.setText(value);
        }
    }

    public void sendOrder(View view) {
        System.out.println(SF.s.getCart().get(0).getName());
        System.out.println("TEST");
    }
}
