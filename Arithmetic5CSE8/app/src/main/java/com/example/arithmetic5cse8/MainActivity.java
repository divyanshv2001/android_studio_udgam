package com.example.arithmetic5cse8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText aVal,bVal;
    Button a,s,m,d;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aVal = findViewById(R.id.aBox);
        bVal = findViewById(R.id.bBox);
        a = findViewById(R.id.addBtn);
        s = findViewById(R.id.subBtn);
        m = findViewById(R.id.mulBtn);
        d = findViewById(R.id.divBtn);
        res = findViewById(R.id.result);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float a = Float.parseFloat(aVal.getText().toString());
                Float b = Float.parseFloat(bVal.getText().toString());
                res.setText("Result:"+(a+b));
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float a = Float.parseFloat(aVal.getText().toString());
                Float b = Float.parseFloat(bVal.getText().toString());
                res.setText("Result:"+(a-b));
            }
        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float a = Float.parseFloat(aVal.getText().toString());
                Float b = Float.parseFloat(bVal.getText().toString());
                res.setText("Result:"+(a*b));
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float a = Float.parseFloat(aVal.getText().toString());
                Float b = Float.parseFloat(bVal.getText().toString());
                if(b==0)
                    res.setText("Division is not possible");
                else
                    res.setText("Result:"+(a/b));
            }
        });
    }
}