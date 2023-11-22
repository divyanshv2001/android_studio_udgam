package com.example.sportsregistration;

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
    EditText n,r;
    Spinner col;
    CheckBox cricket,chess,football,marathon;
    Button reg;
    TextView disp;
    String[] list={"BIT","Presidency","Reva","upes"};
    String x;
    StringBuilder sel=new StringBuilder();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n=findViewById(R.id.name);
        r=findViewById(R.id.rno);
        col=findViewById(R.id.spinner);
        cricket=findViewById(R.id.cricket);
        chess=findViewById(R.id.chess);
        football=findViewById(R.id.football);
        marathon=findViewById(R.id.marathon);
        reg=findViewById(R.id.reg);
        disp=findViewById(R.id.disp);
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,list);
        col.setAdapter(ad);
        col.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                x=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                x="";
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cricket.isChecked()){
                    sel.append("cricket \t");
                }
                if(chess.isChecked()){
                    sel.append("chess \t");
                }
                if (football.isChecked()) {
                    sel.append("football \t");
                }
                if (marathon.isChecked()) {
                    sel.append("marathon \t");
                }
                String d="name: "+n.getText().toString()+"\nrollno: "+r.getText().toString()+"\nuniversity: "+x+"\n selected games: "+sel.toString();
                disp.setText(d);
                Toast.makeText(MainActivity.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                d="";
                sel=null;
            }
        });
    }
}