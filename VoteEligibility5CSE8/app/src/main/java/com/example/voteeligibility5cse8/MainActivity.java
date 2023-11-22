package com.example.voteeligibility5cse8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText name,num,dob;
    Button ver;
    TextView res;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.nameBox);
        num = findViewById(R.id.aadharBox);
        dob = findViewById(R.id.dobBox);
        ver = findViewById(R.id.verifyBtn);
        res = findViewById(R.id.result);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int cYear = cal.get(Calendar.YEAR);
                int cMonth = cal.get(Calendar.MONTH);
                int cDate = cal.get(Calendar.DATE);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_DialogWhenLarge, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String strdate = dayOfMonth+"/"+(month+1)+"/"+year;
                        dob.setText(strdate);
                        age = cYear-year;
                    }
                }, cYear, cMonth, cDate);
                dialog.show();
            }
        });

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(age>=18)
                    res.setText("Name: "+name.getText().toString()+"\nAadhar Number:"+num.getText().toString()+"\nEigible for vote");
                else
                    res.setText("Name: "+name.getText().toString()+"\nAadhar Number:"+num.getText().toString()+"\nNot Eigible for vote");
            }
        });
    }
}