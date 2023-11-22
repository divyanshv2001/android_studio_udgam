package com.example.mid_term_prac;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView dis;
    String a,b,c,d,e,f;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        dis=findViewById(R.id.disp);
        Intent intent=getIntent();
        a=intent.getStringExtra("name");
        b=intent.getStringExtra("resi");
        c=intent.getStringExtra("consent");
        d=intent.getStringExtra("date");
        e=intent.getStringExtra("time");
        f=a+"\n"+b+"\n"+c+"\n"+d+"\n"+e;
        dis.setText(f);
    }
}