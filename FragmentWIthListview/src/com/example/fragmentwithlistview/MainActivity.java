package com.example.fragmentwithlistview;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.view.Menu;

public class MainActivity extends Activity implements Communicator{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Configuration config = getResources().getConfiguration();
		
		if (config.orientation==Configuration.ORIENTATION_PORTRAIT) {
			setContentView(R.layout.activity_main);
		}
		else{
			setContentView(R.layout.activity_main_landscape);
		}
		
		
	}

	@Override
	public void respond(int s) {
		// TODO Auto-generated method stub
		FragmentManager manager = getFragmentManager();
		FragmentB fragB = (FragmentB) manager.findFragmentById(R.id.frag_b);
		fragB.sendData(s);
		
	}

	
}
