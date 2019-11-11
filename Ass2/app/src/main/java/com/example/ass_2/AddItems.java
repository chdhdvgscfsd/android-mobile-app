package com.example.ass_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ass_2.dummy.DummyContent;


public class AddItems extends AppCompatActivity {

    Button btn,btn2;
    WordDbHelper dbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);
        btn = findViewById(R.id.add_item);
        final TextView content = findViewById(R.id.input_item);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = content.getText().toString();
                DummyContent.DummyItem item = new DummyContent.DummyItem(
                        ""+(DummyContent.ITEMS.size()+1), c);
                DummyContent.ITEMS.add(item);
                DummyContent.ITEM_MAP.put(item.id, item);
                Intent i = new Intent();
                ((Activity)v.getContext()).setResult(Activity.RESULT_OK, i);
                finish();
            }
        });

        //for the SQL database
        dbHelper = new WordDbHelper(this);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c = content.getText().toString();
                DummyContent.DummyItem item = new DummyContent.DummyItem(
                        ""+(DummyContent.ITEMS.size()+1), c);
                DummyContent.ITEMS.add(item);
                DummyContent.ITEM_MAP.put(item.id, item);
                long id = dbHelper.insert(db, item.content);
                content.setText("");
                Toast.makeText(view.getContext(), "Word added with id = "+id,
                        Toast.LENGTH_LONG).show();
            }
        });

        btn2 = findViewById(R.id.btnGetAllData);
        final TextView out = findViewById(R.id.txtOutput);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                Cursor c = dbHelper.getAllWords(db);
                String o = "";
                while (c.moveToNext()){
                    String w = c.getString(c.getColumnIndexOrThrow(
                            WordContract.WordEntitiy.COLUMN_NAME_WORD));
                    o+="\n"+w;
                }
                c.close();
                out.setText(o);
            }
        });

    }
}
