package com.example.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView.FindListener;
import android.widget.TextView;
import android.widget.Toast;

public class Broadcast extends BroadcastReceiver {

	TextView tv;
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Toast.makeText(arg0, arg1.getStringExtra("execute2"), Toast.LENGTH_LONG).show();
	}

}
