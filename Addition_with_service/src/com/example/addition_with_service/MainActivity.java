package com.example.addition_with_service;

import com.example.addition_with_service.Addition;
import com.example.addition_with_service.R;

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
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	 EditText et1, et2;
	 Button add;
	 TextView result;
	 protected Addition AddService;
	 ServiceConnection AddServiceConnection;

	 

	  @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
	  et1 = (EditText) findViewById(R.id.editText1);
	  et2 = (EditText) findViewById(R.id.editText2);
	  result = (TextView) findViewById(R.id.textView1);
	  add = (Button) findViewById(R.id.button1);
	  add.setOnClickListener(this);
	  AddServiceConnection = new ServiceConnection() {

		    @Override
		   public void onServiceDisconnected(ComponentName name) {
		    // TODO Auto-generated method stub
		    AddService = null;
		    Log.d("LEE", "service disconnected");
		   }

		    @Override
		   public void onServiceConnected(ComponentName name, IBinder service) {
		    AddService = Addition.Stub.asInterface((IBinder) service);
		    Log.d("LEE", "service connected");
		   }
		  };
		  if (AddService == null) {
		   Intent it = new Intent();
		   Log.v("LEE", "As add service =  null intent being called");
		  it.setAction("setActionName");
		   Log.v("LEE", "action is bind service being called to be binded");
		   bindService(it, AddServiceConnection, Service.BIND_AUTO_CREATE);
		  }

	  
	 }


	  protected void onDestroy() {
	  super.onDestroy();
	  unbindService(AddServiceConnection);
	 };

	  public void onClick(View v) {
	   Log.v("LEE", "onclick is called");
	   int num1 = Integer.parseInt(et1.getText().toString());
	   int num2 = Integer.parseInt(et2.getText().toString());
	   try {
		int summation = AddService.add(num1, num2);
	    result.setText(""+summation);
	    Log.d("LEE", " result is "+result);
	   } catch (RemoteException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	 }
	}