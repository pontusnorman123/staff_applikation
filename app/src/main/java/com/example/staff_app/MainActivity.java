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
    FoodCustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ArrayList<Food> foods = new ArrayList<Food>();
        Food food = new Food(1,"Fisk");
        foods.add(food);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.table_nr_dropdown);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        RecyclerView recycler = findViewById(R.id.recyclerFood);

        //orders = Order.populateOrders();
        customAdapter = new FoodCustomAdapter(MainActivity.this, foods);
        recycler.setAdapter(customAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
       //customAdapter.add_f(f);

    }

    //@Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {}



    public void add_item(View view) {
        count++;
        TextView text = (TextView) findViewById(R.id.nr_of_items);
        text.setText("" + count);
    }


    public void remove_item(View view) {

        if(count <= 0 )
        {
            return;
        }

        count--;
        TextView text = (TextView) findViewById(R.id.nr_of_items);
        text.setText("" + count);
    }
}