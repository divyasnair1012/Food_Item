package com.example.food_itemproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminLoginActivity extends AppCompatActivity {
    Button newu;
    Button signin;
    EditText pass,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        newu=(Button)findViewById(R.id.newuser);

        newu.setVisibility(View.GONE);

         pass = (EditText) findViewById(R.id.email);
        email=(EditText) findViewById(R.id.email);
        signin=(Button) findViewById(R.id.signin);
        //typeface=Typeface.createFromAsset(getAssets(),paths "fonts/font2.ttf")
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent registration=new Intent(LoginActivity.this,RegisrationActivity.class);
                String mail= email.getText().toString();
                String password = pass.getText().toString();
                if (password.equals("admin")&& mail.equals("admin")) {
                    Intent i = new Intent(AdminLoginActivity.this, CheckCustomerActivity.class);
                    startActivity(i);
                }
                else
                {
                    AlertDialog.Builder builder=new AlertDialog.Builder(AdminLoginActivity.this);
                    builder.setMessage("Entered incorrect Email or Password");
                    AlertDialog dialog=builder.show();
                }
            }
        });

    }
}
