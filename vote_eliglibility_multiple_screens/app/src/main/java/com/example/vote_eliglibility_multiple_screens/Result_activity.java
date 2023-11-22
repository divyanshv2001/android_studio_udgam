package com.example.vote_eliglibility_multiple_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result_activity extends AppCompatActivity {
  TextView disp;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        disp=findViewById(R.id.disp);
        Intent it1=getIntent();
        String n=it1.getStringExtra("name");
        String an=it1.getStringExtra("ano");
        int age=it1.getIntExtra("age",0);
        if(age>=18){
            String d=n+"\n"+an+"\n"+"eligible";
            disp.setText(d);
        }
        else{
            String d="not eliglble";
            disp.setText(d);
        }
    }
}