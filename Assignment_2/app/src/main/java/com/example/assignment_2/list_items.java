package com.example.assignment_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class list_items extends AppCompatActivity {

    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    ListView ls;

    public static final String KEY = "ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        Bundle extras = getIntent().getExtras();
        final String item = extras.getString("name");

        ls = findViewById(R.id.list_view);
        itemList = new ArrayList<>();
        itemList.add(item);
        adapter = new ArrayAdapter<String>(list_items.this,android.R.layout.simple_list_item_multiple_choice,itemList);

        ls.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",item);
                startActivity(intent);
            }
        });

        //call the adapter
        //MyAdapter adapter = new MyAdapter(this,itemList[]);


    }

   /* class MyAdapter extends ArrayAdapter<String>{

        Context context;
        ArrayList<String>  rTitle[];

        MyAdapter(Context c,ArrayList title){
            super(c,R.layout.activity_detail,R.id.textView,title);

            this.context = c;
            this.rTitle = title;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.activity_detail, parent, false);
            TextView myTitle = row.findViewById(R.id.textView);

            //set resources on view
            myTitle.setText(rTitle[position]);

            return row;

        }




    }

    */
}
