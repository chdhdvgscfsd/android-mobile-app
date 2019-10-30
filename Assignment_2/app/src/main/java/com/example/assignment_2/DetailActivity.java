package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Button delete;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        final String item = extras.getString("name");
        delete = findViewById(R.id.deleteBtn);
        txtView = findViewById(R.id.textView);
        txtView.setText(item);
        //String msg = getIntent().getExtras(list_items.KEY,"NO DATA");


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem();
            }
        });
    }

    public void deleteItem(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
