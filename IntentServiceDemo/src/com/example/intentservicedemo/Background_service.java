package com.example.intentservicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Background_service extends IntentService {

	public Background_service() {
		super("");
		// TODO Auto-generated constructor stub
	}
	public Background_service(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		Log.v("test","onHandleIntent() running");

	}

}
