package com.example.voteeligibilityintent5cse8;

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
    EditText name,num,dob;
    Button ver;
    int age;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.nameBox);
        num = findViewById(R.id.aadharBox);
        dob = findViewById(R.id.dobBox);
        ver = findViewById(R.id.verifyBtn);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int cYear = cal.get(Calendar.YEAR);
                int cMonth = cal.get(Calendar.MONTH);
                int cDate = cal.get(Calendar.DATE);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_DialogWhenLarge, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int i, int i1, int i2) {
                        String selectedDate = i2+"/"+(i1+1)+"/"+i;
                        dob.setText(selectedDate);
                        age = cYear - i;
                    }
                },cYear,cMonth,cDate);
                dialog.show();
            }
        });
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,ResultActivity.class);
                it.putExtra("NAME",name.getText().toString());
                it.putExtra("AADHAR",num.getText().toString());
                it.putExtra("AGE",age);
                startActivity(it);
            }
        });
    }
}