package com.example.sqldatabaseclass_diary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.SumPathEffect;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	EditText title,contents;
	Button submit,read;
	MyDB dba;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		title= (EditText) findViewById(R.id.editText1);
		contents = (EditText) findViewById(R.id.editText2);
		submit = (Button) findViewById(R.id.button1);
		read = (Button) findViewById(R.id.button2);
		
		dba = new MyDB(this);
		
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
						dba.open();
						saveToDB();
					
				}catch(Exception ee){
					ee.printStackTrace();
				}
				
			}
		});
		read.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dba.open();
				Cursor cursor = dba.getDiary();
				StringBuffer buff = new StringBuffer();
				while (cursor.moveToNext()) {
					int id = cursor.getInt(0);
					String head = cursor.getString(1);
					String con = cursor.getString(2);
					long dat = cursor.getLong(3);
					buff.append(id+" "+head+" "+con+" "+dat+"\n");
				}
				
				Toast.makeText(getApplicationContext(), buff, Toast.LENGTH_LONG).show();
			}
		});
		
	}
	
	public void saveToDB(){
		dba.insertdiary(title.getText().toString(), contents.getText().toString());
		dba.close();
		title.setText("");
		contents.setText("");
		Toast.makeText(getApplicationContext(), "entry successful in database", Toast.LENGTH_SHORT).show();
//		Intent intent = new Intent(this, DisplayDiaries.class);
//		startActivity(intent);
//		
	}


}
