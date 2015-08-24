package com.example.launch;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Launcher extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		
		
		
		Button bg = (Button) findViewById(R.id.google);
		bg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intentGoogle = new Intent(Launcher.this, website.class);
				String url = "http://www.google.com";
				intentGoogle.putExtra("url", url.toString());
				startActivity(intentGoogle);
			}
		});
		
		Button by = (Button) findViewById(R.id.yahoo);
		by.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intentYahoo = new Intent(Launcher.this, website.class);
				String url= "http://www.yahoo.com";
				intentYahoo.putExtra("url", url.toString());
				startActivity(intentYahoo);
				
			}
		});
	}
	
}
