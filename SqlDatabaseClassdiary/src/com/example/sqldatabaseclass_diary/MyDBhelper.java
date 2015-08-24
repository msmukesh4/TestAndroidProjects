package com.example.sqldatabaseclass_diary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBhelper extends SQLiteOpenHelper {

	private static final String CREATE_TABLE="create table "+
			Constants.TABLE_NAME+" ("+
			Constants.KEY_ID+" integer primary key autoincrement, "+
			Constants.TITLE_NAME+" text not null, "+
			Constants.CONTENT_NAME+" text not null, "+
			Constants.DATE_NAME+" long);";
	
	public MyDBhelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try{
			Log.v("test", "creating table..");
			db.execSQL(CREATE_TABLE);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
		try{
			Log.v("test", "updating table..");
			db.execSQL("drop table if exists "+Constants.TABLE_NAME);
			onCreate(db);
			
		}catch(Exception ee){
			ee.printStackTrace();
		}

	}

}
