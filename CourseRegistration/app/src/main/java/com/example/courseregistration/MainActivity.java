package com.example.courseregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText n,r;
    Button submit,reset;
    TextView disp;
    Spinner sp;
    String[] list={"CSE1001","CSE1002","CSE1003","CSE1004"};
    String x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n=findViewById(R.id.n1);//object mapping
        r=findViewById(R.id.rno);
        submit=findViewById(R.id.submit);
        reset=findViewById(R.id.reset);
        sp=findViewById(R.id.spinner);
        disp=findViewById(R.id.disp);
        ArrayAdapter l=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,list);
        //apdapting values from list to the object
        sp.setAdapter(l);//mapping with the object
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                x=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                x="";
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d="name: "+n.getText().toString()+"\n"+"rollno: "+r.getText().toString()+"\n"+"selected course: "+x;
                disp.setText(d);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n.setText("");
                r.setText("");
                disp.setText("");
                sp.setSelection(0);
            }
        });
    }
}