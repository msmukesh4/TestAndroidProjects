package com.example.twoactivity;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ApplicationErrorReport.AnrInfo;
import android.app.ListActivity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Second extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		setListAdapter(new MyAdapter(this,
				android.R.layout.simple_list_item_1,R.id.textView1, 
				getResources().getStringArray(R.array.planets)));
	}
	
	private class MyAdapter extends ArrayAdapter<String> {

		public MyAdapter(Context context, int resource, int textViewResourceId,
				String[] strings) {
	
			super(context, resource, textViewResourceId, strings);
			Log.v("contructor", "contructor called");
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			LayoutInflater inflate = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row=inflate.inflate(R.layout.list_item, parent, false);
			String[] item={"this","are","planets"};
			String[] items=getResources().getStringArray(R.array.planets);
			Log.v("planets", ""+items.toString());
			TextView tv= (TextView) row.findViewById(R.id.textView1);
			TextView tv2= (TextView) row.findViewById(R.id.textView2);
			ImageView iv= (ImageView) row.findViewById(R.id.imageView1);
			
			tv.setText(items[position]);
			if(position<=2){
			tv2.setText(item[position]);}
			if(items[position].equals("Mercury")){
				iv.setImageResource(R.drawable.mercury);
			}else if(items[position].equals("Venus")){
				iv.setImageResource(R.drawable.venus);
			}else if(items[position].equals("Earth")){
				iv.setImageResource(R.drawable.earth);
			}else if(items[position].equals("Mars")){
				iv.setImageResource(R.drawable.mars);
			}else if(items[position].equals("Jupiter")){
				iv.setImageResource(R.drawable.jupiter);
			}else if(items[position].equals("Saturn")){
				iv.setImageResource(R.drawable.saturn);
			} else if(items[position].equals("Uranus")){
				iv.setImageResource(R.drawable.uranus);
			}  else if(items[position].equals("Neptune")){
				iv.setImageResource(R.drawable.neptune);
			}  
			
			
			
			
			return row;
		}
		

	}
	
}
