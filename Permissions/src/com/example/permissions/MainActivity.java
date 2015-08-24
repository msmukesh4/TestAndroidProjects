package com.example.permissions;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ConnectivityManager conman = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		TextView tv = (TextView) findViewById(R.id.mytextview);
		Boolean wifi = conman.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
		
		if(wifi){
			tv.setText("Wifi is ON !!");
		}
		else{
			tv.setText("Wifi is OFF !!");
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
