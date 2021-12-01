package com.example.staff_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrontPageActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        final Button tableOneButton = (Button)findViewById(R.id.tableOneButton);
        tableOneButton.setOnClickListener(this);
        final Button tableTwoButton = (Button)findViewById(R.id.tableTwoButton);
        tableTwoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final Button tableOneButton = (Button)findViewById(R.id.tableOneButton);
        final Button tableTwoButton = (Button)findViewById(R.id.tableTwoButton);

        Intent i = new Intent(getApplicationContext(), MainActivity.class);


        switch (v.getId()){
            case R.id.tableOneButton:
                i.putExtra("key", tableOneButton.getText());
                break;
            case R.id.tableTwoButton:
                i.putExtra("key", tableTwoButton.getText());
                break;
        }

        startActivity(i);


    }
}