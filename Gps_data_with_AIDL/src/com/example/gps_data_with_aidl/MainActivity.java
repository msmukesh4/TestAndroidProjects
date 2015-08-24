package com.example.gps_data_with_aidl;

import com.example.gps_data_with_aidl.R;

import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView longitude1,latitude1,speed1,distance1;
	Button start,stop,update,exit;
	ServiceConnection con;
	protected Gps_data aidl_var;
	Intent it;
	Location got_curr_loc,reference_location=null;
	double distance=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		longitude1 = (TextView) findViewById(R.id.vlongitude);
		latitude1 =  (TextView) findViewById(R.id.vlatitude);
	    distance1 = (TextView) findViewById(R.id.vdistance);
		speed1 = (TextView) findViewById(R.id.vspeed);
		start =  (Button) findViewById(R.id.start_service);
		stop = (Button) findViewById(R.id.stop_service);
		update = (Button) findViewById(R.id.update_values);
		exit =  (Button) findViewById(R.id.exit);
		
		con =  new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName arg0) {
				Log.v("LEE", "service connection disabled in main activity");
				aidl_var = null;
				
			}
			
			@Override
			public void onServiceConnected(ComponentName arg0, IBinder arg1) {
				Log.v("LEE", "service connection enabled in main activity");
				aidl_var = Gps_data.Stub.asInterface((IBinder) arg1);
				Log.v("LEE","--- End of onServiceConnected()");
			}
		};
		if (aidl_var==null) {
			Log.v("LEE", "aidl value is null so new intent is created");
			it =  new Intent();
			it.setAction("action_set");
			Log.v("LEE", "binding service");
			bindService(it, con,Service.BIND_AUTO_CREATE);
		}
		
		
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v("LEE", "Activity started");
				try {
					got_curr_loc = aidl_var.send_location();
				} catch (RemoteException e){
					e.printStackTrace();
				}
				double lo = got_curr_loc.getLongitude();
				double la = got_curr_loc.getLatitude();
				double sp = got_curr_loc.getSpeed();
				if (reference_location == null) {
					distance=0;
				}
				else{
					distance=got_curr_loc.distanceTo(reference_location);
				}
				longitude1.setText(""+lo);
				latitude1.setText(""+la );
				speed1.setText(""+sp );
				distance1.setText(""+distance );
				reference_location = got_curr_loc;
			}
		});
		
		stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v("LEE", "Activity stopped");
				latitude1.setText("-------");
				longitude1.setText("-------");
				speed1.setText("-------");
				distance1.setText("-------");
				
			}
		});
		
		update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v("LEE", "Activity Updating");
				try {
					got_curr_loc = aidl_var.send_location();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				double lo = got_curr_loc.getLongitude();
				double la = got_curr_loc.getLatitude();
				double sp = got_curr_loc.getSpeed();
				if (reference_location == null) {
					distance=0;
				}
				else{
					distance=got_curr_loc.distanceTo(reference_location);
				}
				longitude1.setText(""+lo);
				latitude1.setText(""+la );
				speed1.setText(""+sp );
				distance1.setText(""+distance );
				reference_location = got_curr_loc;
			}
		});
		
		exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v("LEE", "Activity Destroyed ");
				Log.v("LEE", "bye Bye");
				
				unbindService(con);
				System.exit(0);
			}
		});
		
	}
	@Override
	protected void onDestroy() {
		Log.v("LEE", "onDestroy is called service is unBinded");
		unbindService(con);
		super.onDestroy();
	}

}
