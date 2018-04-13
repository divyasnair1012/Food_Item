package com.example.food_itemproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FoodOrderCust extends AppCompatActivity {


    int imageResources[] = {R.drawable.biriyani, R.drawable.soup, R.drawable.icecream, R.drawable.deserts};//this thing will do
    ListView list;
    String menu[] = {"Biriyani","Soup","Icecream","Deserts"};//will tis do?yes
    MyAdapter myAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order_cust);//sorry i was not here.how design came?

        list = findViewById(R.id.listview);
      //  menu=getIntent().getExtras().getStringArray("Item_names");
        myAdap = new MyAdapter(this,menu,imageResources);
        list.setAdapter(myAdap);
    }

    public class MyAdapter extends BaseAdapter {
        String names[];
        int images[];
        Context context;
        public MyAdapter(Context context,String [] names, int[] images) {
            this.names = names;
            this.images=images;
            this.context=context;
        }

        @Override
        public int getCount()
        {
            return names.length;
        }//for

        @Override
        public Object getItem(int position)
        {
            return names[position];
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView== null)
                convertView = View.inflate(context,R.layout.items_view,null);
                ImageView icon = convertView.findViewById(R.id.item_img);
            TextView       name=convertView.findViewById(R.id.item_name);
            icon.setImageResource(images[position]);
            name.setText(names[position]);

            return convertView;
        }
//??want to direct it ti selectionpage
    }
}