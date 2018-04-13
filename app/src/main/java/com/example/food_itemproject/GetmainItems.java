package com.example.food_itemproject;



import android.content.Context;
import android.os.AsyncTask;


import android.widget.RelativeLayout;
import android.widget.TextView;

//import org.apache.http.NameValuePair;
import org.apache.http.NameValuePair;
import org.json.JSONArray;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
import static com.example.akhil.mshop.theTabcall.progressDialog;
*/

/**
 * Created by akhil on 11/23/17.
 */

public class GetmainItems extends AsyncTask<String,String ,String >
{

    Context context;
    /*List<String> mainMenu = new ArrayList<>();
    Map<String, String> main_menu = new HashMap<>();
    TabLayout maintablayout;
    ViewPager mainviewpager;
    MainTabAdapter mainTabAdapter;*/


    public GetmainItems(/*Context context, TabLayout maintablayout, ViewPager mainviewpager, MainTabAdapter mainTabAdapter*/) {
        /*this.context=context;
        this.maintablayout=maintablayout;
        this.mainviewpager=mainviewpager;
        this.mainTabAdapter=mainTabAdapter;*/

    }


    @Override
    protected void onPreExecute() {

    }

    JSONParserArray jParser = new JSONParserArray();
    JSONArray jArray;
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    int k = 0;

//    String getUrl = "http://10.20.1.178/MShop/fetchMain.php";
//String getUrl = "http://192.168.0.10/MShop/fetchMain.php";
        String getUrl = "http://www.thirdeyenet.com/yq/fetchMain.php";
//String getUrl = "http://104.196.23.149/backend/fetchMain.php";







    @Override
    protected String doInBackground(String... args) {


        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            //jArray = jParser.makeHttpRequest(getUrl, "GET", params);

            k = 0;
            while (k < jArray.getJSONArray(0).length()) {


                //main_menu.put(jArray.getJSONArray(0).getString(k + 1), jArray.getJSONArray(0).getString(k));

               // mainMenu.add(jArray.getJSONArray(0).getString(k));
                k += 2;

            }


        } catch (Exception e) {


        }

        return null;
    }

    @Override
    protected void onPostExecute(String args) {
        /* Collections.sort(mainMenu);
         mainviewpager.setOffscreenPageLimit(mainMenu.size());
         mainTabAdapter.Titles(mainMenu,returnMap());
         mainviewpager.setAdapter(mainTabAdapter);
         maintablayout.setupWithViewPager(mainviewpager);*/




    }


    @Override
    protected void onProgressUpdate(String... values) {
        /*progressDialog.setMessage("Loading("+values+"%)");*/
    }



    Map<String,String>  returnMap()
    {
        return null;
    }

}