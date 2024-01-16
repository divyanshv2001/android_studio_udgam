package com.example.frag_prac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
	ListView stuList;
	String[] names = {"ABC","DEF","GHI","JKL","MNO","PQR"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		stuList=findViewById(R.id.list);
		ArrayAdapter adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,names);
		stuList.setAdapter(adapter);
		stuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				BlankFragment br= (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.frag);
				br.display(position);
			}
		});
	}
}