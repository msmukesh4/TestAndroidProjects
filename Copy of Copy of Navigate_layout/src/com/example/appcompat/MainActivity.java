package com.example.appcompat;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.appcompat.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener{

	DrawerLayout drawerlayout;
	ListView listview;
	String[] planets;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		drawerlayout =  (DrawerLayout) findViewById(R.id.drawer_layout);
		
		listview =  (ListView) findViewById(R.id.left_drawer);
		
		listview.setAdapter(new myAdapter(this));
		planets = getResources().getStringArray(R.array.nav_data);
//		
//		listview.setAdapter(new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1,
//				planets));
		listview.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		Toast.makeText(this, planets[position]+" was selected ", Toast.LENGTH_SHORT).show();
		selectItem(position);
	}
	private void selectItem(int arg2) {
		listview.setItemChecked(arg2, true);
		setTitle(planets[arg2]);	
	}
	
	class myAdapter extends BaseAdapter{
		
		
		View row;
		String[] list_data;
		int[] images={R.drawable.profile_pic,R.drawable.earth,
				R.drawable.jupiter,R.drawable.mars,
				R.drawable.ic_launcher,R.drawable.ic_launcher,
				};
		Context context;
		
		public myAdapter(Context context){
			this.context=context;
			list_data = getResources().getStringArray(R.array.nav_data);
			
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list_data.length; 
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return list_data[arg0];
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View convertView, ViewGroup arg2) {
			row=null;
			if (convertView==null) {
				
				LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				row = inflater.inflate(R.layout.custom_layout,arg2, false);
			}else{
				row = convertView;
			}
			final Button b = (Button) row.findViewById(R.id.button1);
			TextView tv = (TextView) row.findViewById(R.id.textView1);
			ImageView iv = (ImageView) row.findViewById(R.id.imageView1);
			if (arg0==0) {
				
				b.setVisibility(View.GONE);
				iv.getLayoutParams().height=40;
				iv.getLayoutParams().width=40;
				tv.getLayoutParams().height=60;
				tv.requestLayout();
				iv.requestLayout();
				
				
			}
			if (arg0==1||arg0==2||arg0==3) {
				iv.getLayoutParams().width=30;
				iv.getLayoutParams().height=30;
				if (arg0==3) {
					
				}
			}
			
			if (arg0==4||arg0==5) {
				b.setVisibility(View.GONE);
				iv.setVisibility(View.GONE);
			}
			
			tv.setText(list_data[arg0]);
			iv.setImageResource(images[arg0]);
			return row;
		}
		
	}
}
