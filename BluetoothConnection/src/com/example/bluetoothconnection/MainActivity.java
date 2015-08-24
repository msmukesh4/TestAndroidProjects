package com.example.bluetoothconnection;

import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tv,tv2;
	 private final static int REQUEST_ENABLE_BT=1;
	 BroadcastReceiver receiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView message = (TextView) findViewById(R.id.message);
		tv= (TextView) findViewById(R.id.textView1);
		tv2= (TextView) findViewById(R.id.textView2);
		tv.setVisibility(View.GONE);
		tv2.setVisibility(View.GONE);
		
		BluetoothAdapter BA = BluetoothAdapter.getDefaultAdapter();
		if (BA.isEnabled()) {
			message.setText("Bluetooth is enabled");			
		}
		else{
			message.setText("Bluetooth is disabled");
			Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(intent,REQUEST_ENABLE_BT);
		}
		
		receiver = new BroadcastReceiver(){
			public void onReceive(android.content.Context context, Intent intent) {
				 final String action = intent.getAction();
			        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
			            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
			                                                 BluetoothAdapter.ERROR);
			            tv2.setVisibility(View.VISIBLE);
			            switch (state) {
			            case BluetoothAdapter.STATE_OFF:
			                tv2.setText("Bluetooth off");
			                break;
			            case BluetoothAdapter.STATE_TURNING_OFF:
			                tv2.setText("Turning Bluetooth off...");
			                break;
			            case BluetoothAdapter.STATE_ON:
			                tv2.setText("Bluetooth on");
			                break;
			            case BluetoothAdapter.STATE_TURNING_ON:
			                tv2.setText("Turning Bluetooth on...");
			                break;
			            }
			        }
				
			};
		};
		 IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
		    registerReceiver(receiver, filter);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		Log.v("LEE", "CAllback is called");
		if (resultCode == RESULT_OK) {
			tv.setVisibility(View.VISIBLE);
			tv.setText("Bluetooth is now Enabled and ready for operations");
		}
		else{
			tv.setVisibility(View.VISIBLE);
			tv.setText("Bluetooth is still disabled");
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		unregisterReceiver(receiver);
		super.onDestroy();
	}
	

}
