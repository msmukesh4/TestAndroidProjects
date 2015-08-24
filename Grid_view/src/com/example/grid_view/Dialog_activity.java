package com.example.grid_view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Dialog_activity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		Intent itt =  getIntent();
		 int imageId = itt.getIntExtra("country_image",R.drawable.india);
		 String cname = itt.getStringExtra("country_name"); 
		 Log.v("onclick parent :: ",itt.getStringExtra("parent") );
		 Log.v("onclick View :: ",itt.getStringExtra("view") );
		 Log.v("onclick id :: ",itt.getStringExtra("id") );
		 
		 Log.v("onclick position :: ",itt.getStringExtra("position") );
		 ImageView ivImageView =(ImageView) findViewById(R.id.imageView1);
		 ivImageView.setImageResource(imageId);
		 
		 TextView tvTextView=(TextView) findViewById(R.id.textView1);
		 tvTextView.setText("This flag belongs to "+cname);
				
	
		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
		
	}

}
