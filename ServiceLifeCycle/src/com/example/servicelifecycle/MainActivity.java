package com.example.servicelifecycle;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
	//	getApplicationContext().bindService(new Intent(getBaseContext(), myService.class), ser, Context.BIND_AUTO_CREATE);
		
		startService(new Intent(getBaseContext(), myService.class));
	}
/*	final ServiceConnection ser =  new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			unbindService(ser);
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			bindService(new Intent(getBaseContext(), myService.class), ser,Context.BIND_AUTO_CREATE);
			
		}
	};*/
	@Override
	protected void onResume() {
		startService(new Intent(getBaseContext(), myService.class));
		super.onResume();
	}
	@Override
	protected void onStop() {
		
		stopService(new Intent(getBaseContext(), myService.class));
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		stopService(new Intent(getBaseContext(), myService.class));
		super.onDestroy();
	}
	
	
}
