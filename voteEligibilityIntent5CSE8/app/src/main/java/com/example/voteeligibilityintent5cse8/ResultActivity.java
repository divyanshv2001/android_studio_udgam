package com.example.voteeligibilityintent5cse8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView res;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        res = findViewById(R.id.result);
        Intent it1 = getIntent();
        String n = it1.getStringExtra("NAME");
        String nu = it1.getStringExtra("AADHAR");
        int a = it1.getIntExtra("AGE",0);
        if(a>=18)
            res.setText("Name:"+n+"\nAadhar Number:"+nu+"\nEligible for vote");
        else
            res.setText("Name:"+n+"\nAadhar Number:"+nu+"\nNot Eligible for vote");
    }
}