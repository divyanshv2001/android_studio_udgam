package com.example.batterypercentage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.ProgressBar;
import android.widget.TextView;

public class battery_receiver extends BroadcastReceiver {
	ProgressBar p;
	TextView d;
	public battery_receiver(ProgressBar p, TextView d) {
		this.d=d;
		this.p=p;
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		int per=intent.getIntExtra("level",0);
		if(per>=75){
			d.setText("Battery Percentage : "+per);
			p.setProgress(per);
			p.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
		}
		else if(per<75 && per>=20 ){
			d.setText("Battery Percentage : "+per);
			p.setProgress(per);
			p.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
		}
		else{
			d.setText("Battery Percentage : "+per);
			p.setProgress(per);
			p.setProgressTintList(ColorStateList.valueOf(Color.RED));
		}
	}
}
