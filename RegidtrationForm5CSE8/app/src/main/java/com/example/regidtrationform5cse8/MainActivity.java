package com.example.regidtrationform5cse8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameVal,fnameVal;
    RadioGroup rg;
    RadioButton rb;
    AutoCompleteTextView place;
    Button sub;
    String[] loc = {"Ahmedabad","Bangalore","Bombay","Calcutta","Chennai","Delhi","Hyderabad","Pune"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameVal = findViewById(R.id.nameBox);
        fnameVal = findViewById(R.id.fnameBox);
        rg = findViewById(R.id.genderGroup);
        place = findViewById(R.id.placeBox);
        sub = findViewById(R.id.submit);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.select_dialog_item,loc);
        place.setAdapter(ad);
        place.setThreshold(1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = findViewById(checkedId);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res = "Name:"+nameVal.getText().toString()+"\nFather Name:"+fnameVal.getText().toString()+"\nGender:"+rb.getText()+"\nPlace of Birth:"+place.getText().toString();
                Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
            }
        });
    }
}