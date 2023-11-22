package com.example.musicplayerservices5cse8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changePlayAction(View v){
        if(v==findViewById(R.id.playImage)){
            Intent it = new Intent(MainActivity.this,MyService.class);
            startService(it);
        }
        if(v==findViewById(R.id.stopImage)){
            Intent it = new Intent(MainActivity.this,MyService.class);
            stopService(it);
        }
    }
}