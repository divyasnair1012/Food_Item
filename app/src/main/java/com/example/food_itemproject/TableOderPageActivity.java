package com.example.food_itemproject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TableOderPageActivity extends AppCompatActivity {
    Spinner time,date;
    Button check,book;
    String times[] = {"12:30 PM","3:30 PM","5:30 PM"};
    String dates[] = new String[5];
    Calendar calendar;
    String formattedDate;
    Context context;
    int play = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_oder_page);
        time = findViewById(R.id.spinner4);
        date = findViewById(R.id.spinner5);
        check = findViewById(R.id.check);
        book = findViewById(R.id.booke_);
        calendar = Calendar.getInstance();
        context = this;
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

        time.setAdapter(new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,times));
        date.setAdapter(new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,dates));
        time.getSelectedItem();
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time_ = (String) time.getSelectedItem();
                try {
                    time_ =  new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("hh:mm a").parse(time_));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String date_ = (String) date.getSelectedItem();
                Log.d("time",time_);
                Log.d("date",date_);
              new checkFunction().execute(time_,date_);
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(play==1) {
                    View ex = View.inflate(context, R.layout.table_booking_dialog, null);
                    TextView time_ = ex.findViewById(R.id.time);
                    TextView date_ = ex.findViewById(R.id.date);
                    final Spinner person_ = ex.findViewById(R.id.spinner);
                    Button book = ex.findViewById(R.id.book_button);
                    time_.setText("Selected Time: "+  time.getSelectedItem());
                    date_.setText("Selected Date: "+  date.getSelectedItem());
                    String per[] = {"1", "2", "3", "4", "5"};
                    ArrayAdapter adapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, per);
                    person_.setAdapter(adapter);
                    ProgressDialog.Builder builder = new ProgressDialog.Builder(context);
                    builder.setView(ex);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    book.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String time_ = (String) time.getSelectedItem();
                            try {
                                time_ =  new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("hh:mm a").parse(time_));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            String date_ = (String) date.getSelectedItem();
                            Log.d("time",time_);
                            Log.d("date",date_);
                            new updateBook().execute(time_,date_,getIntent().getExtras().getString("email"), String.valueOf(person_.getSelectedItem()));

                        }
                    });

                }

                else
                    Toast.makeText(context,"Seats not Available/Check Availability",Toast.LENGTH_SHORT).show();
            }
        });


        time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                play = 0;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        date.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                play = 0;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }





    class checkFunction extends AsyncTask<String,String,String>{

        String URL = new getUrl().setUrl("checkAvail.php");
        JSONParserArray jparser = new JSONParserArray();
        JSONArray jArray=new JSONArray();
        List<NameValuePair> params =new ArrayList<>();
        String name;

        @Override
        protected String doInBackground(String... strings) {
            params.add(new BasicNameValuePair("time",strings[0]));
            params.add(new BasicNameValuePair("date",strings[1]));
            jArray=jparser.makeHttpRequest(URL,"GET",params);
            try {
                 name = jArray.getJSONArray(0).getString(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return name;
        }

        @Override
        protected void onPostExecute(String result) {
            if(result.equals("book_full")) {
                Toast.makeText(getApplicationContext(), "Booking Full", Toast.LENGTH_SHORT).show();
                play = 0;
            } else if(result.equals("available")) {
                Toast.makeText(getApplicationContext(), "Tables are Available", Toast.LENGTH_SHORT).show();
                play = 1;
            }else {
                Toast.makeText(getApplicationContext(), "Error Response", Toast.LENGTH_SHORT).show();
                play = 0;
            }
        }
    }

    class updateBook extends AsyncTask<String,String,String>{

        String URL = new getUrl().setUrl("updateAvail.php");
        JSONParserArray jparser = new JSONParserArray();
        JSONArray jArray=new JSONArray();
        List<NameValuePair> params =new ArrayList<>();
        String name;

        @Override
        protected String doInBackground(String... strings) {
            params.add(new BasicNameValuePair("time",strings[0]));
            params.add(new BasicNameValuePair("date",strings[1]));
            params.add(new BasicNameValuePair("userid",strings[2]));
            params.add(new BasicNameValuePair("guests",strings[3]));
            jArray=jparser.makeHttpRequest(URL,"GET",params);
            try {
                name = jArray.getJSONArray(0).getString(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return name;
        }

        @Override
        protected void onPostExecute(String result) {
            if(result.equals("update complete")) {
                Toast.makeText(getApplicationContext(), "Update Success", Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(getApplicationContext(), "Error Response", Toast.LENGTH_SHORT).show();

            }
            play = 0;
        }
    }



}
