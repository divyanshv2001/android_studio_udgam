package com.example.prac1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText n;
    Spinner s;
    AutoCompleteTextView a;
    Button sub;
    String[] c={"cse1001","cse1002","cse1003"};
    String x;
    String[] loc={"banglore","delhi","goa","prayagraj","pune"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n=findViewById(R.id.Name);
        s=findViewById(R.id.spinner);
        a=findViewById(R.id.autol);
        sub=findViewById(R.id.submit);
        ArrayAdapter adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,c);
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
        ArrayAdapter adapter1=new ArrayAdapter<>(MainActivity.this, android.R.layout.select_dialog_item,loc);
        a.setAdapter(adapter1);
        a.setThreshold(1);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d="name: "+n.getText().toString()+"\n"+"course: "+x+"Home city: "+a.getText().toString();
                Toast.makeText(MainActivity.this, d, Toast.LENGTH_SHORT).show();
            }
        });
}
}