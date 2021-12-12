package com.example.staff_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class UndeliveredOrders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_undelivered_orders);


        RecyclerView recycler = findViewById(R.id.recycler);

        //SO.s.context = UndeliveredOrders.this;

        SO.s.customAdapter = new OrdersCustomAdapter(UndeliveredOrders.this);
        recycler.setAdapter(SO.s.customAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(UndeliveredOrders.this));


        // FROM DATABASE
        /*XmlReaderTask xmlReaderTask = new XmlReaderTask();
        xmlReaderTask.tableList = null;
        xmlReaderTask.handler = new Handler();//Håller  koll på trådsom är ansvar för  nätverk
        xmlReaderTask.execute();*/
    }
}