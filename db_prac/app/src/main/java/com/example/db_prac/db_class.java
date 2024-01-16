package com.example.db_prac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class db_class extends SQLiteOpenHelper {
	public db_class(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String x="create table stu (sname varchar(20),rno varchar(20),marks int(20))";
		db.execSQL(x);
//		db.close();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public void insert(String name, String rno, int marks) {
		SQLiteDatabase db=getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put("sname",name);
		values.put("rno",rno);
		values.put("marks",marks);
		db.insert("stu",null,values);
		db.close();
	}

	public String display(String name) {
		SQLiteDatabase db=getReadableDatabase();
		StringBuilder x=new StringBuilder();
		Cursor cursor=db.rawQuery("select * from stu where sname = ? ",new String[]{name});
		while(cursor.moveToNext()){
			String n=cursor.getString(0);
			String rno=cursor.getString(1);
			String marks=cursor.getString(2);
			x.append(n+"\t\t\t\t\t\t\t"+rno+"\t\t\t\t\t\t\t"+marks+"\n");
		}
		return String.valueOf(x);
	}

	public int display_n() {
		int f=0;
		SQLiteDatabase db=getReadableDatabase();
		StringBuilder x=new StringBuilder();
		Cursor cursor=db.rawQuery("select * from stu",null);
		while(cursor.moveToNext()){
		f++;
		}
		return  f;
	}
}
