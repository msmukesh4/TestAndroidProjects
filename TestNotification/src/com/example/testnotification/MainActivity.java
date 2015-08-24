package com.example.testnotification;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
//				NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//				Notification notify = new Notification(android.R.drawable.stat_notify_more,
//						"this is ticker text", System.currentTimeMillis());
//				
//				Context context = MainActivity.this;
//				CharSequence title = "THis is notification title";
//				CharSequence details = "this is notification details";
//				
//				Intent intent  = new Intent(context, MainActivity.class);
//				PendingIntent pending = PendingIntent.getActivity(context,0, intent, 0);
//				
//				notify.setLatestEventInfo(context, title, details, pending);
//				nm.notify(0, notify);
				
			}
		});
	}

	

}
