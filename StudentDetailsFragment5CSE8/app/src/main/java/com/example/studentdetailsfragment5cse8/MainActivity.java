package com.example.studentdetailsfragment5cse8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView stuList;
    String[] names = {"ABC","DEF","GHI","JKL","MNO","PQR"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stuList = findViewById(R.id.StudentList);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,names);
        stuList.setAdapter(adapter);
        stuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DetailsFragment frag = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentPortion);
                frag.display(i);
            }
        });
    }
}