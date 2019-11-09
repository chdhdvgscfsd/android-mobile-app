package com.example.ass_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ass_2.dummy.DummyContent;

public class AddItems extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);
        btn = findViewById(R.id.add_item);
        final TextView content = findViewById(R.id.input_item);
        //final TextView desc = findViewById(R.id.details);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = content.getText().toString();
                //String d = desc.getText().toString();
                DummyContent.DummyItem item = new DummyContent.DummyItem(
                        ""+(DummyContent.ITEMS.size()+1), c);
                DummyContent.ITEMS.add(item);
                DummyContent.ITEM_MAP.put(item.id, item);
                Intent i = new Intent();
                ((Activity)v.getContext()).setResult(Activity.RESULT_OK, i);
                finish();
            }
        });

    }
}
