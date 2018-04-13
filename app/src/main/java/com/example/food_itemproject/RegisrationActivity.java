package com.example.food_itemproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.json.JSONArray;
import org.json.JSONException;

import org.w3c.dom.Text;

public class RegisrationActivity extends AppCompatActivity {

    Context context;
    String result;
    public  RegisrationActivity(Context context){this.context=context;}
    //String URL="http://10.20.0.33/minip/register.php";
  public   RegisrationActivity()
  {

  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisration);
        Button Register =(Button) findViewById(R.id.Reg);

        //signin=(Button) findViewById(R.id.);
        //typeface=Typeface.createFromAsset(getAssets(),paths "fonts/font2.ttf")
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent registration=new Intent(LoginActivity.this,RegisrationActivity.class);
                Intent registration=new Intent(RegisrationActivity.this,LoginActivity.class);
                startActivity(registration);
            }
        });
    }

}
