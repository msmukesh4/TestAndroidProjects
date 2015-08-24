package com.example.testontouchevent;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	int x = 0;
	int y = 0;
	long tap_1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		RelativeLayout Rlayout = (RelativeLayout) findViewById(R.id.RelativeLayout1);
		Rlayout.setOnTouchListener(new OnTouchListener(){

		TextView tv_x = (TextView) findViewById(R.id.textView1);
		TextView tv_y = (TextView) findViewById(R.id.textView2);
		TextView tap = (TextView) findViewById(R.id.textView3);

			@Override
			public boolean onTouch(View arg0, MotionEvent m) {
				int action = m.getActionMasked();
				
				int curr_x,curr_y;
				
				switch (action) {
				
				case MotionEvent.ACTION_DOWN:
					
					long tap_2 = System.currentTimeMillis();
					if (tap_2-tap_1<=250) {
						tap.setText("Double tapped");
					}
					else
						tap.setText("Single Tapped");
					Toast.makeText(getApplicationContext(), "Action Down ", Toast.LENGTH_SHORT).show();
					x = (int) m.getX();
					y = (int) m.getY();
					tap_1=tap_2;
					break;
					
				case MotionEvent.ACTION_UP:
					 curr_x =(int) m.getX();
					 curr_y = (int) m.getY();

					tv_x.setText("X = "+x+" Current X = "+curr_x);
					tv_y.setText("Y = "+y+" Current Y = "+curr_y);

					if(curr_x-x>=70)
						Toast.makeText(getApplicationContext(), "Action Moved right ", Toast.LENGTH_SHORT).show();
					if(curr_y-y>70)
						Toast.makeText(getApplicationContext(), "Action Moved down ", Toast.LENGTH_SHORT).show();
					
					//Toast.makeText(getApplicationContext(), "Action Up ", Toast.LENGTH_SHORT).show();
					break;
					
				case MotionEvent.ACTION_MOVE:
					
					break;
					
				default:
					break;
				}
				
				return true;
			}
			
		});
		
	}

	

}
