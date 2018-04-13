package com.example.food_itemproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TableOderPageActivity extends AppCompatActivity {
    Spinner time,date;
    Button check;
    String times[] = {"12:30 PM","3:30 PM","5:30 PM"};
    String dates[] = new String[5];
    Calendar calendar;
    String formattedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_oder_page);
        time = findViewById(R.id.spinner4);
        date = findViewById(R.id.spinner5);
        check = findViewById(R.id.check);
        calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         formattedDate = df.format(calendar.getTime());
        dates[0] = formattedDate;
        calendar.add(Calendar.DATE,1);

        formattedDate = df.format(calendar.getTime());
        dates[1] = formattedDate;
        calendar.add(Calendar.DATE,1);

        formattedDate = df.format(calendar.getTime());
        dates[2] = formattedDate;
        calendar.add(Calendar.DATE,1);

        formattedDate = df.format(calendar.getTime());
        dates[3] = formattedDate;
        calendar.add(Calendar.DATE,1);

        formattedDate = df.format(calendar.getTime());
        dates[4] = formattedDate;
        calendar.add(Calendar.DATE,1);

        time.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,times));
        date.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,dates));



    }
}
