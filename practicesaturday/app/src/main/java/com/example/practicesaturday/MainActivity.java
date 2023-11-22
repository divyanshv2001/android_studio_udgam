package com.example.practicesaturday;

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
    Spinner s;
    RadioGroup x;
    RadioButton y;
    Button sub;
    String x1;
    TextView disp;
    String[] ach={"sports","paper presentation","project presentation","hackathon"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.name);
        b=findViewById(R.id.rno);
        x=findViewById(R.id.choices);
        s=findViewById(R.id.spinner);
        sub=findViewById(R.id.submit);
        disp=findViewById(R.id.disp);
        ArrayAdapter ad=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,ach);
        s.setAdapter(ad);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                x1=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                x1="";
            }
        });
        x.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                y=findViewById(i);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d="name: "+a.getText().toString()+"\nrollno :"+b.getText().toString()+"\nchoice: "+x1+"\nsection: "+y.getText();
                disp.setText(d);
                Toast.makeText(MainActivity.this, "sumitted sucessfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}