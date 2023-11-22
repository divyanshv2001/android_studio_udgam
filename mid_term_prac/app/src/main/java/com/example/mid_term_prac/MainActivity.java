package com.example.mid_term_prac;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText a;
    Spinner s;
    Button sub;
    String[] z={"yes","no"};
    String ch;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.name);
        s=findViewById(R.id.spinner);
        sub=findViewById(R.id.prc);
        ArrayAdapter ad=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,z);
        s.setAdapter(ad);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ch=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                ch=null;
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this, MainActivity2.class);
                it.putExtra("name",a.getText().toString());
                it.putExtra("consent",ch);
                startActivity(it);
            }
        });
    }
}