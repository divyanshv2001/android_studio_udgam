package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changePlayAction(View view) {
        if(view==findViewById(R.id.play)){
            Intent it=new Intent(MainActivity.this, music.class);
            startService(it);
        }
        if(view==findViewById(R.id.stop)){
            Intent i=new Intent(MainActivity.this, music.class);
            stopService(i);
        }
    }
}