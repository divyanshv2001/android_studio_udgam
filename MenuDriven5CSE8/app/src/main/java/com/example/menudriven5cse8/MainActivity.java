package com.example.menudriven5cse8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Toolbar bar;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = findViewById(R.id.myToolBar);
        tv = findViewById(R.id.result);
        setSupportActionBar(bar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.searchId){
            tv.setText("You selected Search Option");
            return true;
        }
        else if(item.getItemId()==R.id.settingsId){
            tv.setText("You selected Settings Option");
            return true;
        }
        else if(item.getItemId()==R.id.paymentsId){
            tv.setText("You selected Payments Option");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}