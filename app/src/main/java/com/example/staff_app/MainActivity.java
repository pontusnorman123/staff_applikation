package com.example.staff_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DatabaseCode.Resturangorder;
import DatabaseCode.XmlReaderTask;
import DatabaseCode.XmlResturangOrderWriterTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendButton = findViewById(R.id.sendOrderButton);
        // set menu items (from dish in DB)
        //SF.s.resetAll();
        /*MenuItem food = new MenuItem("Fiskpinnar. Potatis");
        MenuItem food2 = new MenuItem("Ungsbakad Lax. Potatis");
        SF.s.addFood(food);
        SF.s.addFood(food2);

        SF.s.addFood(new MenuItem("McDonald's from next door"));
        SF.s.addFood(new MenuItem("kyckling sushi"));
        SF.s.addFood(new MenuItem("1 raw potato"));*/

        XmlReaderTask xmlReaderTask = new XmlReaderTask();
        xmlReaderTask.menuitemTable = null;
        xmlReaderTask.handler = new Handler();//Håller  koll på trådsom är ansvar för  nätverk
        xmlReaderTask.execute();

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

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<MenuItem> items = SF.s.getCart();
                XmlResturangOrderWriterTask xmlWriterTask = new XmlResturangOrderWriterTask();
                xmlWriterTask.resturangorders.resturangorderTable = new ArrayList<Resturangorder>();
                int rSize = xmlReaderTask.resturangTable.resturangorderTable.size();
                int lastID=1;
                for (int i = 0; i<rSize; i++){
                    if(xmlReaderTask.resturangTable.resturangorderTable.get(i).id > lastID)
                        lastID = xmlReaderTask.resturangTable.resturangorderTable.get(i).id;
                }
                lastID++;
                int loopNr = (items.size())+lastID;
                for(int i = lastID; i < loopNr; i++){
                    //xmlWriterTask.tableList = null;
                    Resturangorder element = new Resturangorder();
                    element.id = i;
                    element.tablenr = Integer.valueOf(extras.getString("key"));
                    Long tsLong = System.currentTimeMillis();
                    String ts = tsLong.toString();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String dateString = formatter.format(new Date(Long.parseLong(ts)));
                    element.timestamp =dateString;
                    element.notes = "Nothing to add";
                    element.dishid = items.get(i-lastID).getDishID();
                    xmlWriterTask.resturangorders.resturangorderTable.add(element);

                }
                xmlWriterTask.handler = new Handler();
                xmlWriterTask.execute(xmlWriterTask.resturangorders);
                SF.s.resetAll();
            }
        });

    }


    /*public void sendOrder(View view) {
        System.out.println(SF.s.getCart().get(0).getName());
        System.out.println("TEST");
    }*/
}
