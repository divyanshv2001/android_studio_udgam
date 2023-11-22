package com.example.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        res=findViewById(R.id.res);
        Intent it=getIntent();
        String t,f,d;
        f=it.getStringExtra("flv");
        t=it.getStringExtra("time");
        d=it.getStringExtra("date");
        String res1="Flavour: "+f+"\n"+"Time: "+t+"\n"+"Date: "+d;
        res.setText(res1);
    }
}