package com.example.lifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("LEE", "onCreate() method was called ");
	}
	
	@Override
	public void onStart(){
		super.onStart();
		Log.e("LEE", "onStart() method was called");
	}
	@Override
	public void onResume(){
		super.onResume();
		Log.e("LEE", "onResume() method was called");
	}
	@Override
	public void onPause(){
		super.onPause();
		Log.e("LEE", "onPause() method was called");
	}
	
	@Override
	public void onStop(){
		super.onStop();
		Log.e("LEE", "onStop() method was called");
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.e("LEE", "onDestroy() method was called");
	}

}
