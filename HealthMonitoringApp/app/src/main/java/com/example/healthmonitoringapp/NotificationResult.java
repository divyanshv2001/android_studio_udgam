package com.example.healthmonitoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationResult extends AppCompatActivity {
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_result);
        onNewIntent(getIntent());
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(100);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras!=null) {
            if (extras.containsKey("Message")) {
                setContentView(R.layout.activity_notification_result);
                String msg = extras.getString("Message");
                res = findViewById(R.id.result);
                res.setText("Report: "+msg);
            }
            super.onNewIntent(intent);
        }
    }
}