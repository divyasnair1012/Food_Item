package com.example.food_itemproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckCustomerActivity extends AppCompatActivity {
      Button add,del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_customer);

        add=(Button)findViewById(R.id.af);
        del =(Button)findViewById(R.id.df);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckCustomerActivity.this,Addfoodctivity.class);
                startActivity(intent);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckCustomerActivity.this,DeleteFoodActivity.class);
                startActivity(intent);
            }
        });

    }
}
