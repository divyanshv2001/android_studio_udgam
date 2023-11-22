package com.example.mid_term_prac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    int cy,cmn,cd,ch,cm;
    String d,t;
    AutoCompleteTextView al;
    Button sub;
    String[] z={"pune","pingala","prayagraj","pilibhit","mumbai","mansarovar","delhi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        al=findViewById(R.id.autoCompleteTextView);
        sub=findViewById(R.id.button);
        Intent it=getIntent();
        String name=it.getStringExtra("name");
        String consent=it.getStringExtra("consent");
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.select_dialog_item,z);
        al.setAdapter(ad);
        al.setThreshold(1);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent it1 =new Intent(MainActivity2.this, MainActivity3.class);
            it1.putExtra("name",name);
            it1.putExtra("consent",consent);
            it1.putExtra("resi",al.getText().toString());
            it1.putExtra("date",d);
            it1.putExtra("time",t);
            startActivity(it1);
            }
        });
    }

    public void settime(View view) {
        Calendar c=Calendar.getInstance();
        ch=c.get(Calendar.HOUR);
        cm=c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity2.this, android.R.style.Theme_DeviceDefault, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                t=i+":"+i1;
            }
        },ch,cm,true);
        timePickerDialog.show();
    }

    public void setdate(View view) {
        Calendar c=Calendar.getInstance();
        cy=c.get(Calendar.YEAR);
        cmn=c.get(Calendar.MONTH);
        cd=c.get(Calendar.DATE);
        DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity2.this, android.R.style.Theme_DeviceDefault, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                d=i2+"/"+(i1+1)+"/"+i;
            }
        },cy,cmn,cd);
        datePickerDialog.show();
    }
}