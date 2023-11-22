package com.example.despinner5cse8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText nameVal,rollnoVal;
    Spinner course;
    Button sub, rest;
    TextView res;
    String[] subjects = {"Mobile Application Development","R Programming","Java Full Stack",".Net Full Stack"};
    String SelectedCourse;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameVal = findViewById(R.id.nameBox);
        rollnoVal = findViewById(R.id.rollnoBox);
        course = findViewById(R.id.courseList);
        sub = findViewById(R.id.submitBtn);
        rest = findViewById(R.id.resetBtn);
        res = findViewById(R.id.result);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,subjects);
        course.setAdapter(adapter);
        course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SelectedCourse = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "Name: "+nameVal.getText().toString()+"\nRoll No: "+rollnoVal.getText().toString()+"\nSelected Course: "+SelectedCourse;
                res.setText(str);
            }
        });
        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("");
                nameVal.setText("");
                rollnoVal.setText("");
                course.setSelection(0);
            }
        });
    }
}