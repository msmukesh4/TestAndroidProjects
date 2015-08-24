package com.example.list_sample;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.planets)));
	}

}
