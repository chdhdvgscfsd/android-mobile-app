package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> itemList;
    ArrayAdapter<String> adapter;
    EditText inputText;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.saveBtn);
        inputText = findViewById(R.id.addText);


        //redirect to next page
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openList();
            }
        });
    }

    public void openList(){
        String item = String.valueOf(inputText.getText());

        Intent intent = new Intent(this,list_items.class);
         intent.putExtra("name", (Serializable) item);
        startActivity(intent);
    }
}
