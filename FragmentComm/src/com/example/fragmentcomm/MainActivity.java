package com.example.fragmentcomm;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.view.Menu;

public class MainActivity extends Activity implements Communicator{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void respond(String arg) {
		FragmentManager manger = getFragmentManager();
		FragmentB bfrag = (FragmentB) manger.findFragmentById(R.id.frag_b);
		bfrag.changeData(arg);
	}
}
