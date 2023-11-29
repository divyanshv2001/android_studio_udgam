package com.example.store_detatils_in_database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class db  extends SQLiteOpenHelper {

	public db(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table stu(sid varchar(20) primary key,sname varchar(20))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public void insert(String sid, String sname) {
		SQLiteDatabase db=this.getWritableDatabase();
		db.execSQL("insert into stu values(?,?)",new String[]{sid,sname});
		db.close();
	}

	public void delete(String sid) {
		SQLiteDatabase db=this.getWritableDatabase();
		db.execSQL("delete from stu where sid=? ",new String[]{sid});
		db.close();
	}

	public String display() {
		SQLiteDatabase db=this.getReadableDatabase();
		StringBuilder x= new StringBuilder();
		Cursor cursor=db.rawQuery("select * from stu",null);
		while (cursor.moveToNext()){
			String id=cursor.getString(0);
			String name=cursor.getString(1);
			x.append(id).append("\t\t\t").append(name).append("\n");
		}
		db.close();
		return x.toString();
	}
}
