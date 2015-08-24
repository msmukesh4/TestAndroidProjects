package com.example.fragmenttype;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SimpleFragment f = new SimpleFragment();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transition = manager.beginTransaction();
		
		transition.add(R.id.container,f,"mike");
		
		transition.commit();
		
	}
	

}
