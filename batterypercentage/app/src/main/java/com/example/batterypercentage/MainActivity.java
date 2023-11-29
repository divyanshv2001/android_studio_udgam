package com.example.batterypercentage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	ProgressBar p;
	TextView d;
	battery_receiver br;
	Button x;
	@SuppressLint("MissingInflatedId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		p=findViewById(R.id.b_percent);
		d=findViewById(R.id.disp);
		x=findViewById(R.id.sub);
		br=new battery_receiver(p,d);
		x.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				IntentFilter itf =new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
				registerReceiver(br,itf);
			}
		});
	}
}