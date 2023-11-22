package com.example.voteeligibility;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText a,b,c;
    Button sub;
    TextView d;
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
        d=findViewById(R.id.display);
        //for setting calendar we have to use the clicked object hence the code below
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar x=Calendar.getInstance();
                int cyear=x.get(Calendar.YEAR);//fetch the current year
                int cmonth=x.get(Calendar.MONTH);//fetch the current month
                int cday=x.get(Calendar.DATE);//fetch the current day
                DatePickerDialog dp=new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_DialogWhenLarge, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i/*year*/, int i1 /*month*/, int i2/*day*/){
                        String userdate=i2+"/"+(i1+1)+"/"+i;
                        //set date for the component
                        c.setText(userdate);
                        age=cyear-i;
                    }
                },cyear,cmonth,cday);
                dp.show();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(age>=18){
                    String d1="name: "+a.getText().toString()+"\nAadhar No."+b.getText().toString();
                    d.setText(d1);
                    Toast.makeText(MainActivity.this, "Eligible To Vote", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Not Eligible", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}