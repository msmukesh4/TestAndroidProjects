package com.example.android_additionservice;

import com.example.android_additionservice.IAdd;
import com.example.android_additionservice.R;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
 EditText et1, et2;
 Button add;
 TextView result;
 protected IAdd AddService;
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
    	    Toast.makeText(getApplicationContext(), "Service Disconnected",
    	    Toast.LENGTH_SHORT).show();
    	    Log.d("IRemote", "Binding - Service disconnected");
  	   }

  	    @Override
  	   public void onServiceConnected(ComponentName name, IBinder service) {
      	  // TODO Auto-generated method stub
      	  AddService = IAdd.Stub.asInterface((IBinder) service);
      	  Toast.makeText(getApplicationContext(),"Addition Service Connected", Toast.LENGTH_SHORT).show();
      	  Log.d("IRemote", "Binding is done - Service connected");
  	   }
	  };
	  if (AddService == null) {
  	   Intent it = new Intent();
  	   it.setAction("service.Calculator");
  	   // binding to remote service
  	   bindService(it, AddServiceConnection, Service.BIND_AUTO_CREATE);
	  }

  
 }


  protected void onDestroy() {
  super.onDestroy();
  unbindService(AddServiceConnection);
 };

  public void onClick(View v) {
   // TODO Auto-generated method stub
    switch (v.getId()) {
      case R.id.button1: {
        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());
        try {
          add.setText("Result:" + AddService.add(num1, num2));
          Log.d("IRemote", "Binding - Add operation");
        } catch (RemoteException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      break;
    }
  }
}