package com.example.custom_list_from_url;



import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;


public class Dialog_activity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
				
		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
		
	}

}
