package com.example.staff_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private Spinner spinner;
    private static final String[] paths = {"1", "2","3","4","5","6","7",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.table_nr_dropdown);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    //@Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

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