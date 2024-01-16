package com.example.db_prac;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	Button i,d;
	EditText a,b,c;
	TextView disp;
	db_class x;
	@SuppressLint("MissingInflatedId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		a=findViewById(R.id.name);
		b=findViewById(R.id.rno);
		c=findViewById(R.id.marks);
		i=findViewById(R.id.insert);
		d=findViewById(R.id.disp_q);
		disp=findViewById(R.id.disp);
		x=new db_class(MainActivity.this,"stu",null,1);
		i.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String name=a.getText().toString();
				String rno=b.getText().toString();
				int marks=Integer.parseInt(c.getText().toString());
				x.insert(name,rno,marks);
				Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
			}
		});
		d.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String d=x.display(a.getText().toString());
				int n=x.display_n();
				disp.setText(d+""+n);
			}
		});
	}
}