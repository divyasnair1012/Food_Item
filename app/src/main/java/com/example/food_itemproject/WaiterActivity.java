package com.example.food_itemproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WaiterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button new11,signin;
        final EditText pass,email;
        // typeface are classes which we use to define custom fonts in android


            pass=(EditText) findViewById(R.id.email);
            email=(EditText) findViewById(R.id.email);
            new11 =(Button) findViewById(R.id.newuser);
            new11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WaiterActivity.this,RegisrationActivity.class);
                    startActivity(intent);
                }
            });
            signin=(Button) findViewById(R.id.signin);
            //typeface=Typeface.createFromAsset(getAssets(),paths "fonts/font2.ttf")
            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent registration=new Intent(LoginActivity.this,RegisrationActivity.class);
                    String mail;
                    mail = email.getText().toString();
                    String password = pass.getText().toString();
                    if (password.equals("waiter")&& mail.equals("waiter")) {
                        Intent i = new Intent(WaiterActivity.this, WaiterFunActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        AlertDialog.Builder builder=new AlertDialog.Builder(WaiterActivity.this);
                        builder.setMessage("Entered incorrect Email or Password");
                        AlertDialog dialog=builder.show();
                    }
                }
            });
        }
    }




