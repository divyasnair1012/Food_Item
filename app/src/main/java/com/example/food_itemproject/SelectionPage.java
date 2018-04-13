package com.example.food_itemproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static android.view.View.*;

public class SelectionPage extends AppCompatActivity {

    ImageView table_book,order,Offers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectionpage);//record chethotte?r
        table_book = findViewById(R.id.tabBook);
        table_book .setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectionPage.this,TableOderPageActivity.class);
                startActivity(intent);
            }

        });
        order = findViewById(R.id.menu_book);

        order .setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectionPage.this,FoodOrderCust.class);
                startActivity(intent);
            }

        });
        Offers =  findViewById(R.id.offers);
        Offers .setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectionPage.this,offers.class);
                startActivity(intent);
            }

        });

        //give the corresponding images
    }
}
