package com.example.registrationform;

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
    EditText name,fname;
    RadioGroup rg;
    AutoCompleteTextView resi;
    Button sub;
    RadioButton rb;
    String[] loc={"delhi","prayagraj","pune","mumbai","banglore"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        fname=findViewById(R.id.fname);
        rg=findViewById(R.id.rdg);
        resi=findViewById(R.id.residence);
        sub=findViewById(R.id.submit);
        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.select_dialog_item,loc);
        resi.setAdapter(ad);
        resi.setThreshold(1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb=findViewById(i);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res="name: "+name.getText().toString()+"\n"+"fathername: "+fname.getText().toString()+"\n"+"gender"+rb.getText()+"\n"+"residence: "+resi.getText().toString();
                Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
            }
        });
    }

}