package com.example.staff_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class UndeliveredOrders extends AppCompatActivity {

    void addNew(Order order) {
        SO.s.orders.add(order);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_undelivered_orders);


        // FROM HARDCODED TEST ARRAY
        ArrayList<Order> test_orders = new ArrayList<Order>(5);
        test_orders.add(new Order(1, "fish", 20));
        test_orders.add(new Order(3, "potato", 5));
        test_orders.add(new Order(5, "salad", 5));
        test_orders.add(new Order(3, "McDonald's from next door", 10));
        test_orders.add(new Order(2, "chicken sushi", 10));

        RecyclerView recycler = findViewById(R.id.recycler);

        //SO.s.context = UndeliveredOrders.this;

        SO.s.customAdapter = new OrdersCustomAdapter(UndeliveredOrders.this);
        recycler.setAdapter(SO.s.customAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(UndeliveredOrders.this));

        SO.s.addOrders(test_orders);


        // FROM DATABASE
        /*XmlReaderTask xmlReaderTask = new XmlReaderTask();
        xmlReaderTask.tableList = null;
        xmlReaderTask.handler = new Handler();//Håller  koll på trådsom är ansvar för  nätverk
        xmlReaderTask.execute();*/
    }
}