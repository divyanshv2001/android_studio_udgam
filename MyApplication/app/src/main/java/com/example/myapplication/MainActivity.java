package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //create object for all components
    EditText num1,num2;
    Button add,mul,sub,div1;
    TextView rst;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        add=findViewById(R.id.Addbtn);
        mul=findViewById(R.id.mul);
        div1=findViewById(R.id.div1);
        sub=findViewById(R.id.sub);
        rst=findViewById(R.id.rst);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float a=Float.parseFloat(num1.getText().toString());
                Float b=Float.parseFloat(num2.getText().toString());
                rst.setText("result: "+(a+b));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float a=Float.parseFloat(num1.getText().toString());
                Float b=Float.parseFloat(num2.getText().toString());
                rst.setText("result: "+(a-b));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float a=Float.parseFloat(num1.getText().toString());
                Float b=Float.parseFloat(num2.getText().toString());
                rst.setText("result: "+(a*b));
            }
        });
        div1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float a=Float.parseFloat(num1.getText().toString());
                Float b=Float.parseFloat(num2.getText().toString());
                if(b==0){
                    rst.setText("Error");
                }
                rst.setText("result: "+(a/b));
            }
        });
    }
}