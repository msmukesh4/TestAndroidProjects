package com.example.fragmentwithlistview_withintent;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Another_class extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.portrait_another_layout);
		// TODO Auto-generated method stub
		
		Intent intent =getIntent();
		int index = intent.getIntExtra("index", 0);
		
		FragmentB f2 =  (FragmentB) getFragmentManager().findFragmentById(R.id.frag_b);
		if (f2!=null) {
			f2.sendData(index);
		}
		
		
	}

}
