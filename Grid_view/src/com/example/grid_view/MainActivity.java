package com.example.grid_view;

import java.util.ArrayList;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnItemClickListener{

	GridView gv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gv = (GridView) findViewById(R.id.gridView1);
		gv.setAdapter(new myAdapter(this));
		
		gv.setOnItemClickListener(this);
	}

	 
	class countries{
		int imageId;
		String countryName;
		public countries(int image,String country) {
			Log.v("LEE", "inside countries constructor");
			imageId= image;
			countryName=country;
		}
	}
	
	class myHolder{
		ImageView iv;
		
		public myHolder(View v) {
			iv= (ImageView) v.findViewById(R.id.imageView1);
			Log.v("LEE", "inside myholder constructor");
		}
		
	}
	
	class myAdapter extends BaseAdapter{
		countries country_list;
		ArrayList<countries> list;
		
		public myAdapter(Context context) {
			Log.v("LEE", "inside myAdapter constructor");
			list = new ArrayList<countries>();
			String[] country = context.getResources().getStringArray(R.array.countri);
			int[] flagsImages = {R.drawable.australia, R.drawable.brazil,R.drawable.canada,
							R.drawable.france,R.drawable.germany,R.drawable.india,
							R.drawable.israel,R.drawable.italy,R.drawable.japan,
							R.drawable.southafrica,R.drawable.uk,R.drawable.usa};
			for(int i=0;i<12;i++){
			    country_list = new countries(flagsImages[i], country[i]);
				list.add(country_list);
			}
			}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Log.v("LEE", "--------- staring getView----------");
			myHolder holder;
			View row=convertView;
			if(row==null){
				LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				row=inflater.inflate(R.layout.my_simple_layout, parent, false);
				holder =  new myHolder(row);
				row.setTag(holder);
				
			}
			else{
			 holder= (myHolder) row.getTag();
			}
			countries tempCountry = list.get(position);
			holder.iv.setImageResource(tempCountry.imageId);
			holder.iv.setTag(tempCountry);
			return row;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent it = new Intent(this,Dialog_activity.class);
		
		myHolder hold = (myHolder) view.getTag();
		countries c = (countries) hold.iv.getTag();
		it.putExtra("view", ""+view);
		it.putExtra("parent", ""+parent);
		it.putExtra("position", ""+position);
		it.putExtra("id", ""+id);
		it.putExtra("country_image", c.imageId);
		it.putExtra("country_name", c.countryName);
		startActivity(it);
		
	}

}
