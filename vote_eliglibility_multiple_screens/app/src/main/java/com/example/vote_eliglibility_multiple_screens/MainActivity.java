package com.example.vote_eliglibility_multiple_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText a,b,c;
    Button sub;
    int age;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.name);
        b=findViewById(R.id.ano);
        c=findViewById(R.id.date);
        sub=findViewById(R.id.submit);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int cyear=cal.get(Calendar.YEAR);
                int cmonth=cal.get(Calendar.MONTH);
                int cday=cal.get(Calendar.DATE);
                DatePickerDialog dp=new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_DialogWhenLarge, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i /*year*/, /*month*/int i1,/*day*/ int i2) {
                    String date=i2+"/"+(i1+1)+"/"+i;
                    c.setText(date);
                    age=cyear-i;
                    }
                },cyear,cmonth,cday);
                dp.show();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,Result_activity.class);//2 parameter current activity then destination activity
                it.putExtra("name",a.getText().toString());
                it.putExtra("ano",b.getText().toString());
                it.putExtra("age",age);
                startActivity(it);
            }
        });
    }
}