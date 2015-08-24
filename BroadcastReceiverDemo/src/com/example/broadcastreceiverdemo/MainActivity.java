package com.example.broadcastreceiverdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView status,receive;
	Button trigger_action1,trigger_action2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        status = (TextView) findViewById(R.id.execute);
        receive = (TextView) findViewById(R.id.execute2); 
        status.setVisibility(View.INVISIBLE);
        receive.setVisibility(View.INVISIBLE);
        trigger_action1 = (Button) findViewById(R.id.button1);
        trigger_action2 = (Button) findViewById(R.id.button2);
       
		trigger_action1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				status.setVisibility(View.VISIBLE);
				status.setText("sending action 1");
				Intent it = new Intent(MainActivity.this,Broadcast.class);
				it.putExtra("execute2","action1 " );
				sendBroadcast(it);
			}
		});
		
		trigger_action2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				status.setVisibility(View.VISIBLE);
				status.setText("sending action 2");
				Intent itt = new Intent(MainActivity.this,Broadcast.class);
				itt.putExtra("execute2","action2 " );
				sendBroadcast(itt);
			}
		});
		
        
    }
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    //	unregisterReceiver(receiver);
    	super.onPause();
    }
  
}
