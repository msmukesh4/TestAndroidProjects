package com.example.sqldatabaseclass_diary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class MyDB {
	
	private SQLiteDatabase db;
	private MyDBhelper dbhelper;
	private Context context;
	
	public MyDB(Context c) {
		// TODO Auto-generated method stub
		Log.v("test", "constructing ...");
		context = c;
		dbhelper = new MyDBhelper(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
	}
	public void close(){
		Log.v("test", "closing connection...");
		db.close();
	}
	public void open() throws SQLException{
		try{
			Log.v("test", "opening connection...");
			db= dbhelper.getWritableDatabase();
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}
	
	public long insertdiary(String title, String content){
		try{
			Log.v("test", "entrying...");
			ContentValues newTaskValue = new ContentValues();
			newTaskValue.put(Constants.TITLE_NAME, title);
			newTaskValue.put(Constants.CONTENT_NAME, content);
			newTaskValue.put(Constants.DATE_NAME,java.lang.System.currentTimeMillis());
			return db.insert(Constants.TABLE_NAME, null, newTaskValue);
		} catch(SQLiteException ex) {
			
		}
		return -1;
	}
	public Cursor getDiary(){
		String[] col = {Constants.KEY_ID,Constants.TITLE_NAME,Constants.CONTENT_NAME,Constants.DATE_NAME};
		Cursor c = db.query(Constants.TABLE_NAME, col, null, null, null, null, null);
		return c;
	}

}
