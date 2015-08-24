package com.example.fragmentwithlistview_withintent;



import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.Menu;

public class MainActivity extends Activity implements Communicator{

	FragmentA f1;
	FragmentB f2;
	FragmentManager manager;
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
		manager=getFragmentManager();	
		f1 = (FragmentA) manager.findFragmentById(R.id.frag_a);
	}

	@Override
	public void respond(int s) {
		// TODO Auto-generated method stub
	
		f2 = (FragmentB) manager.findFragmentById(R.id.frag_b);
		if (f2!=null && f2.isVisible()) {
			f2.sendData(s);
		}
		else{
			Intent intent = new Intent(this,Another_class.class);
			intent.putExtra("index", s);
			startActivity(intent);
		}
		
	}

	
}
