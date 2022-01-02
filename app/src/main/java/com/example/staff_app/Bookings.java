package com.example.staff_app;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import DatabaseCode.GetRetrofitBooking;


public class Bookings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Button button = findViewById(R.id.BookingButton);

        BookingDB();

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookingDB();
            }
        });*/
    }

    public void BookingDB(){
        GetRetrofitBooking getRetrofitBooking = new GetRetrofitBooking();
        getRetrofitBooking.bookingTable = null;
        getRetrofitBooking.name1 = findViewById(R.id.textView9);
        getRetrofitBooking.guest1 = findViewById(R.id.textView7);
        getRetrofitBooking.time1 = findViewById(R.id.textView6);
        getRetrofitBooking.name2 = findViewById(R.id.textView13);
        getRetrofitBooking.guest2 = findViewById(R.id.textView10);
        getRetrofitBooking.time2 = findViewById(R.id.textView11);
        getRetrofitBooking.name3 = findViewById(R.id.textView15);
        getRetrofitBooking.guest3 = findViewById(R.id.textView17);
        getRetrofitBooking.time3 = findViewById(R.id.textView16);
        getRetrofitBooking.name4 = findViewById(R.id.textView21);
        getRetrofitBooking.guest4 = findViewById(R.id.textView20);
        getRetrofitBooking.time4 = findViewById(R.id.textView19);
        getRetrofitBooking.name5 = findViewById(R.id.textView25);
        getRetrofitBooking.guest5 = findViewById(R.id.textView24);
        getRetrofitBooking.time5 = findViewById(R.id.textView23);
        getRetrofitBooking.name6 = findViewById(R.id.textView29);
        getRetrofitBooking.guest6 = findViewById(R.id.textView27);
        getRetrofitBooking.time6 = findViewById(R.id.textView28);
        getRetrofitBooking.name7 = findViewById(R.id.textView29);
        getRetrofitBooking.guest7 = findViewById(R.id.textView27);
        getRetrofitBooking.time7 = findViewById(R.id.textView28);
        getRetrofitBooking.handler = new Handler();//Håller  koll på trådsom är ansvar för  nätverk
        getRetrofitBooking.execute();
    }

}