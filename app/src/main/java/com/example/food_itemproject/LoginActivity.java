package com.example.food_itemproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.*;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

public class LoginActivity extends AppCompatActivity {

    //athalla emulator working.s no probs even thiss project
    TextView AdminLogin;
    Button new1,signin;
    EditText pass,email;
    // typeface are classes which we use to define custom fonts in android
    //String menu[]={"Biriyaani","Soups","Ice Cream","Deserts"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//xbox to record  i did it once
        setContentView(R.layout.login);
        AdminLogin=(TextView)findViewById(R.id.AdminLogin);
        pass=(EditText) findViewById(R.id.pass);
        email=(EditText) findViewById(R.id.email);
        new1 =(Button) findViewById(R.id.newuser);
                       new1.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               Intent intent = new Intent(LoginActivity.this,RegisrationActivity.class);
                               startActivity(intent);
                           }
                       });
        signin=(Button) findViewById(R.id.signin);
        //typeface=Typeface.createFromAsset(getAssets(),paths "fonts/font2.ttf")
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent registration=new Intent(LoginActivity.this,RegisrationActivity.class);
                String password = pass.getText().toString();

                if(email.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter an Email-ID",Toast.LENGTH_SHORT).show();
                }

                else if(pass.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter the password",Toast.LENGTH_SHORT).show();
                }

                else
                   new fetchOperation().execute(email.getText().toString(),pass.getText().toString());

            }
        });
    }
    class fetchOperation extends AsyncTask<String,String,String>
    {
        String result,name;
//      String URL="http://10.20.0.33/minip/login.php";
      String URL = new getUrl().setUrl("login.php");
      JSONParserArray jparser = new JSONParserArray();
      JSONArray jArray=new JSONArray();
      List<NameValuePair> params =new ArrayList<>();
        String username;
        @Override
        protected String doInBackground(String... values) {

             username=values[0];
            String password=values[1];
             params.add(new BasicNameValuePair("userid",username));
             params.add(new BasicNameValuePair("password",password));

            jArray=jparser.makeHttpRequest(URL,"GET",params);
            try{
                int count=jArray.getJSONArray(0).length();
                name = jArray.getJSONArray(0).getString(1);
                System.out.print(count);
                System.out.print(jArray.getJSONArray(0).getString(0));
                Log.d("Response",jArray.getJSONArray(0).getString(0));
                result=jArray.getJSONArray(0).getString(0);


            } catch (JSONException e) {
                e.printStackTrace();
            }

            return result;

        }

        protected void  onPostExecute(String result)
        {
            Log.d("Response",result) ;
            if (result.equals("false"))
                 Toast.makeText(getApplicationContext(),"Login Fail",Toast.LENGTH_SHORT).show();
             else if (result.equals("Error Respose"))
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
        else
        {
            Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
            Intent   foodOrder = new Intent(LoginActivity.this,SelectionPage.class);
            foodOrder.putExtra("name",result);
            foodOrder.putExtra("email",username);
            startActivity(foodOrder);
            finish();
        }
        }
    }
}

//just start the scan and shout
