package com.example.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button odr;
    EditText a,b;
    Spinner ch;
    String[] choice={"vanila","chocholate","bluberry","black forset","strawberry"};
    String f,t,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.name);
        b=findViewById(R.id.pno);
        ch=findViewById(R.id.spinner);
        odr=findViewById(R.id.submit);
        ArrayAdapter ad=new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,choice);
        ch.setAdapter(ad);
        ch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                f=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            f="no flavour selected";
            }
        });
        odr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Result.class);
                intent.putExtra("flv",f);
                intent.putExtra("date",d);
                intent.putExtra("time",t);
                startActivity(intent);
            }
        });
    }
      public void setdate (View view){
          Calendar cal=Calendar.getInstance();
          int cyear=cal.get(Calendar.YEAR);
          int cmonth=cal.get(Calendar.MONTH);
          int cday=cal.get(Calendar.DATE);
          DatePickerDialog dialog=new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_DialogWhenLarge, new DatePickerDialog.OnDateSetListener() {
              @Override
              public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                  d=i2+"/"+(i1+1)+"/"+i;
              }
          },cyear,cmonth,cday);
          dialog.show();
        }
        public void settime(View view){
            Calendar cal1=Calendar.getInstance();
            int chour=cal1.get(Calendar.HOUR);
            int cmin=cal1.get(Calendar.MINUTE);
            TimePickerDialog tpd=new TimePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_DialogWhenLarge, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i/*min*/, int i1/*hour*/) {
                    t=i+":"+i1;
                }
            },chour,cmin,false);//for false 12hrs format for true 24 hrs format
            tpd.show();
    }

}