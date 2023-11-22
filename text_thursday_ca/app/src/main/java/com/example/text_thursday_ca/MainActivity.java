package com.example.text_thursday_ca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText a,b;
    RadioGroup rdg;
    RadioButton r;
    Spinner s;
    Button sub;
    TextView disp;
    String[] ch={"java","python","others"};
    String x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.n);
        b=findViewById(R.id.mail);
        rdg=findViewById(R.id.rdg);
        s=findViewById(R.id.spinner);
        sub=findViewById(R.id.submit);
        disp=findViewById(R.id.disp);
        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                r=findViewById(i);
            }
        });
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,ch);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                x=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                x="";
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(x=="java"||x=="python"){
               String disp1=a.getText().toString()+"\n"+b.getText().toString()+"\n"+r.getText().toString()+"\n"+x+"\n"+"Sucessfully Registered";
               disp.setText(disp1);
            }
            else{
                disp.setText("not eligible");
            }
            }
        });
    }
}