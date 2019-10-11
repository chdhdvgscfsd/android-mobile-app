package com.example.mathcalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView output, error_message;
    EditText input1,input2,input3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnSubmit);
        output = findViewById(R.id.outputText);
        input1 = findViewById(R.id.q_imput);
        input2 = findViewById(R.id.s_imput);
        input3 = findViewById(R.id.e_imput);
        error_message = findViewById(R.id.error_msg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //convert all input to string
                String inputStr1 = input1.getText().toString();
                String inputStr2 = input2.getText().toString();
                String inputStr3 = input3.getText().toString();

                //check all inputs are filled
                if ( !(inputStr1.equals(null) || inputStr1.equals("")|| inputStr2.equals(null) || inputStr2.equals("")
                        || inputStr3.equals(null) || inputStr3.equals(""))){

                    double inputval1 = new Double(inputStr1).doubleValue();
                    double inputval2 = new Double(inputStr2).doubleValue();
                    double inputval3 = new Double(inputStr3).doubleValue();
                    //output
                    double outputVal = (46*inputval1) - (10*inputval2) + (24*inputval3);
                    //cast outputVal to string
                    String result = Double.toString(outputVal);
                    error_message.setText("");

                    output.setText(result);
                }
                else {
                    error_message.setText("Invalid Entry");
                }
            }
        });

    }


}
