package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText a,b;
    TextView rst;
    Button cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.h1);
        b = findViewById(R.id.w1);
        cal = findViewById(R.id.cal);
        rst = findViewById(R.id.rst);
//        cal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                float a1=Float.parseFloat(a.getText().toString());
//                float b1=Float.parseFloat(b.getText().toString());
//                float c= (b1/(float) Math.pow(a1,2));
//                if(c<18.5){
//                    rst.setText("BMI: "+c+" underweight");
//                } else if (c>=18.5&&c<25) {
//                    rst.setText("BMI: "+c+" healthy weight");
//                } else if (c>=25&&c<30) {
//                    rst.setText("BMI: "+c+" overweight");
//                }
//                else {
//                    rst.setText("BMI: " + c + " obesity");
//                }
//            }
//        });
    }
        public void calm (View v){
            float a1 = Float.parseFloat(a.getText().toString());
            float b1 = Float.parseFloat(b.getText().toString());
            float c = (b1 / (float) Math.pow(a1, 2));
            if (c < 18.5) {
                rst.setText("underweight");
            } else if (c >= 18.5 && c < 25) {
                rst.setText(" healthy weight");
            } else if (c >= 25 && c < 30) {
                rst.setText(" overweight");
            } else {
                rst.setText(" obesity");
            }
            Toast.makeText(this, "Your Bmi :"+c, Toast.LENGTH_SHORT).show();
        }
    }
