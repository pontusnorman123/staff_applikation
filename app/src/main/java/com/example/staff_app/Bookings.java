package com.example.staff_app;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class Bookings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);


        // FROM HARDCODED TEST ARRAY
        SO.s.resetAll();
        ArrayList<Order> test_orders = new ArrayList<Order>(5);
        test_orders.add(new Order(1));
        test_orders.add(new Order(3));
        test_orders.add(new Order(5));
        test_orders.add(new Order(3));
        test_orders.add(new Order(2));

        RecyclerView recycler = findViewById(R.id.recycler);

        //SO.s.context = UndeliveredOrders.this;

        SO.s.customAdapter = new OrdersCustomAdapter(Bookings.this);
        recycler.setAdapter(SO.s.customAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(Bookings.this));

        SO.s.addOrders(test_orders);


        // FROM DATABASE
        /*XmlReaderTask xmlReaderTask = new XmlReaderTask();
        xmlReaderTask.tableList = null;
        xmlReaderTask.handler = new Handler();//Håller  koll på trådsom är ansvar för  nätverk
        xmlReaderTask.execute();*/
    }
}