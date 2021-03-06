package com.example.staff_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import DatabaseCode.GetRetrofitDelivered;

public class FrontPageActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        //TEST
        //SO.s.addOrder(new Order(1));

        //ANTAL UndeliveredOrders
        SO.s.numberOfOrders = (TextView)findViewById(R.id.nrOfOrdersTXT);
        SO.s.updateOrderNumberInFrontPage();

        //KNAPPAR
        Button undeliveredOrdersButton = (Button) findViewById(R.id.undeliveredOrdersButton);

        final Button tableOneButton = (Button)findViewById(R.id.tableOneButton);
        tableOneButton.setOnClickListener(this);
        final Button tableTwoButton = (Button)findViewById(R.id.tableTwoButton);
        tableTwoButton.setOnClickListener(this);
        final Button tableThreeButton = (Button)findViewById(R.id.tableThreeButton);
        tableThreeButton.setOnClickListener(this);
        final Button tableFourButton = (Button)findViewById(R.id.tableFourButton);
        tableFourButton.setOnClickListener(this);
        final Button tableFiveButton = (Button)findViewById(R.id.tableFiveButton);
        tableFiveButton.setOnClickListener(this);
        final Button tableSixButton = (Button)findViewById(R.id.tableSixButton);
        tableSixButton.setOnClickListener(this);
        final Button tableSevenButton = (Button)findViewById(R.id.tableSevenButton);
        tableSevenButton.setOnClickListener(this);

        // start database loading...
        int MILLISECONDS_BETWEEN_UPDATES = 1000; // 5 seconds
        // Handler is similar to async
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                //FROM DATABASE
                //SO.s.databaseLoad();

                //FROM TESTARRAY
                GetRetrofitDelivered getRetrofitDelivered = new GetRetrofitDelivered();
                getRetrofitDelivered.viewList = null;
                getRetrofitDelivered.handler = new Handler();//H??ller  koll p?? tr??dsom ??r ansvar f??r  n??tverk
                getRetrofitDelivered.execute();

                handler.postDelayed(this, MILLISECONDS_BETWEEN_UPDATES);
            }
        }, MILLISECONDS_BETWEEN_UPDATES);
    }


    @Override
    public void onClick(View v) {

        final Button tableOneButton = (Button)findViewById(R.id.tableOneButton);
        final Button tableTwoButton = (Button)findViewById(R.id.tableTwoButton);

        final Button tableThreeButton = (Button)findViewById(R.id.tableThreeButton);
        final Button tableFourButton = (Button)findViewById(R.id.tableFourButton);
        final Button tableFiveButton = (Button)findViewById(R.id.tableFiveButton);
        final Button tableSixButton = (Button)findViewById(R.id.tableSixButton);
        final Button tableSevenButton = (Button)findViewById(R.id.tableSevenButton);

        Intent i = new Intent(getApplicationContext(), MainActivity.class);


        switch (v.getId()){
            case R.id.tableOneButton:
                i.putExtra("key", tableOneButton.getText());
                break;
            case R.id.tableTwoButton:
                i.putExtra("key", tableTwoButton.getText());
                break;
            case R.id.tableThreeButton:
                i.putExtra("key", tableThreeButton.getText());
                break;
            case R.id.tableFourButton:
                i.putExtra("key", tableFourButton.getText());
                break;
            case R.id.tableFiveButton:
                i.putExtra("key", tableFiveButton.getText());
                break;
            case R.id.tableSixButton:
                i.putExtra("key", tableSixButton.getText());
                break;
            case R.id.tableSevenButton:
                i.putExtra("key", tableSevenButton.getText());
                break;
        }

        startActivity(i);


    }


    public void goToUndeliveredOrders(View view) {
        Intent i = new Intent(getApplicationContext(), UndeliveredOrders.class);
        startActivity(i);
    }

    public void goToBooking(View view){
        Intent i = new Intent(getApplicationContext(), Bookings.class);
        startActivity(i);
    }
}