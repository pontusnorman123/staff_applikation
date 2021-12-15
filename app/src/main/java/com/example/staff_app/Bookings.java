package com.example.staff_app;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import DatabaseCode.XmlReaderBooking;


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
        XmlReaderBooking xmlReaderBooking = new XmlReaderBooking();
        xmlReaderBooking.bookingTable = null;
        xmlReaderBooking.name1 = findViewById(R.id.textView9);
        xmlReaderBooking.guest1 = findViewById(R.id.textView7);
        xmlReaderBooking.time1 = findViewById(R.id.textView6);
        xmlReaderBooking.name2 = findViewById(R.id.textView13);
        xmlReaderBooking.guest2 = findViewById(R.id.textView10);
        xmlReaderBooking.time2 = findViewById(R.id.textView11);
        xmlReaderBooking.name3 = findViewById(R.id.textView15);
        xmlReaderBooking.guest3 = findViewById(R.id.textView17);
        xmlReaderBooking.time3 = findViewById(R.id.textView16);
        xmlReaderBooking.name4 = findViewById(R.id.textView21);
        xmlReaderBooking.guest4 = findViewById(R.id.textView20);
        xmlReaderBooking.time4 = findViewById(R.id.textView19);
        xmlReaderBooking.name5 = findViewById(R.id.textView25);
        xmlReaderBooking.guest5 = findViewById(R.id.textView24);
        xmlReaderBooking.time5 = findViewById(R.id.textView23);
        xmlReaderBooking.name6 = findViewById(R.id.textView29);
        xmlReaderBooking.guest6 = findViewById(R.id.textView27);
        xmlReaderBooking.time6 = findViewById(R.id.textView28);
        xmlReaderBooking.name7 = findViewById(R.id.textView29);
        xmlReaderBooking.guest7 = findViewById(R.id.textView27);
        xmlReaderBooking.time7 = findViewById(R.id.textView28);
        xmlReaderBooking.handler = new Handler();//Håller  koll på trådsom är ansvar för  nätverk
        xmlReaderBooking.execute();
    }

}