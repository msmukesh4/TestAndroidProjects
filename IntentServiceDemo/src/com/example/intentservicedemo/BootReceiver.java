package com.example.intentservicedemo;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Log.v("test","Running Broadcast Receiver" );
		Intent intent = new Intent(arg0, Background_service.class);
		PendingIntent pendingIntent = PendingIntent.getService(arg0, -1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		AlarmManager alarmManager = (AlarmManager) arg0.getSystemService(Context.ALARM_SERVICE);
		alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(), 1000, pendingIntent);
	}

}
