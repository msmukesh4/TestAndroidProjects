package com.example.layout_program;


import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		LinearLayout linearLayout =  new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		
		
		LayoutParams linear_layout_Params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		setContentView(linearLayout,linear_layout_Params);
		
		
		LayoutParams lay_param = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		TextView tv = new TextView(this);
		tv.setText("Text_view");
		linearLayout.addView(tv, lay_param);
		
		LinearLayout.LayoutParams left_margin =  new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		Button btn1 = new Button(this);
		btn1.setText("Button 1");
		left_margin.leftMargin = 50;
		linearLayout.addView(btn1, left_margin);
		
		LinearLayout.LayoutParams right_gravity = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		right_gravity.gravity = Gravity.RIGHT;
		Button btn2 = new Button(this);
		btn2.setText("Button 2");
		linearLayout.addView(btn2, right_gravity);
		
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Btn 2 clicked", Toast.LENGTH_LONG).show();
				
			}
		});
		
		
		
		
		
		
		
	}

}
