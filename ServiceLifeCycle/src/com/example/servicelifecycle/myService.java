package com.example.servicelifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class myService extends Service {

	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.e("LEE", "onCreate called");
		super.onCreate();
	}
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.d("LEE", "onBind called");
		return null;
	}

	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d("LEE", "onRebind called");
		super.onRebind(intent);
	}
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d("LEE", "onUnbind called");
		return super.onUnbind(intent);
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.e("LEE", "onStartCommand called");
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.e("LEE", "onDestroy called");
		super.onDestroy();
	}
}
