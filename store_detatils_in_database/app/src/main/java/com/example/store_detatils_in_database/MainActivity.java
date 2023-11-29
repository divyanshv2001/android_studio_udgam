package com.example.store_detatils_in_database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	EditText a,b;
	Button c,d,e;
	TextView t;

	db x;

	@SuppressLint("MissingInflatedId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		a=findViewById(R.id.name);
		b=findViewById(R.id.rno);
		c=findViewById(R.id.ins);
		d=findViewById(R.id.del);
		e=findViewById(R.id.disp);
		t=findViewById(R.id.out);

		x=new db(MainActivity.this,"stu",null,1);
		c.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String sid=b.getText().toString();
				String sname=a.getText().toString();
				x.insert(sid,sname);
				Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
			}
		});
		d.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String sid=b.getText().toString();
				x.delete(sid);
				Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
			}
		});
		e.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String display = x.display();
				t.setText(display);
			}
		});
	}
}