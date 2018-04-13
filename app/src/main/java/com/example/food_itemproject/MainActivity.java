package com.example.food_itemproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    Button btn1,btn2 ;
    ViewPager viewPager;
     //CustomSwipeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // viewPager = (ViewPager)findViewById(R.id.view_Pager);
       // adapter = new CustomSwipeAdapter;

        btn1=(Button)findViewById(R.id.Cust);
        btn2=(Button)findViewById(R.id.admin);
        /*btn3=(Button)findViewById(R.id.waiter);*/


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity.this,AdminLoginActivity.class);
                //here we need to start the intent
                startActivity(intent1);



            }
        });


       /* btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=nTHEY KokNOW okokew Intent(MainActivity.this,WaiterActivity.class);
                //here we need to start the intent
                startActivity(intent1);

            }
        });*/


    }
    public void openRegister()
    {
          Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        //here we need to start the intent
        startActivity(intent);

         // this loads the activity specified in the intent
        //  openRegister();
    }


}
