package com.example.sportseventform5cse8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText nameVal,rollnoVal;
Spinner coll;
CheckBox ca,ch,cr;
Button reg;
TextView res;
String[] univ = {"Presidency","Reva","Christ","Jain","Bangalore city"};

String selectedCollege;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameVal = findViewById(R.id.nameBox);
        rollnoVal = findViewById(R.id.rollnoBox);
        coll = findViewById(R.id.collegeList);
        ca = findViewById(R.id.carromsBox);
        ch = findViewById(R.id.chessBox);
        cr = findViewById(R.id.cricketBox);
        reg = findViewById(R.id.registerBtn);
        res = findViewById(R.id.result);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,univ);
        coll.setAdapter(adapter);
        coll.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCollege = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder games = new StringBuilder();
                if(ca.isChecked())
                    games.append("Carroms ");
                if(ch.isChecked())
                    games.append("Chess ");
                if(cr.isChecked())
                    games.append("Cricket");
                String str = "Name :"+nameVal.getText().toString()+"\nRoll No:"+rollnoVal.getText().toString()+"\nCollege Name:"+selectedCollege+"\nRegistered Games: "+games.toString();
                res.setText(str);
                Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}