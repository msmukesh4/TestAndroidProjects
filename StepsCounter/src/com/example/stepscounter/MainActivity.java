package com.example.stepscounter;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener,OnClickListener,OnSeekBarChangeListener{
	
	SensorManager Smanager;
	Sensor sensor;
	SensorEventListener listner,orientationlistner;
	int steps=0;
	TextView coordinates,step,seekthreshold;
	float yprev=0,threshold=2;
	Button reset;
	SeekBar seekbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Smanager = (SensorManager) getSystemService(SENSOR_SERVICE);
		sensor= Smanager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
		coordinates =  (TextView) findViewById(R.id.textView1);
		step=(TextView) findViewById(R.id.textView2);
		reset=(Button) findViewById(R.id.button1);
		seekbar=(SeekBar) findViewById(R.id.seekBar1);
		seekthreshold=(TextView) findViewById(R.id.textView3);
		seekthreshold.setText("Threshold set to : 2");
		step.setText("steps : 0");
		Log.v("LEE", "sensor manager created"+sensor);
		Smanager.registerListener((SensorEventListener) this, sensor,SensorManager.SENSOR_DELAY_NORMAL);
		seekbar.setOnSeekBarChangeListener(this);
		reset.setOnClickListener(this);
		
	}
	
	@Override
	protected void onResume() {
		Log.v("LEE", "sensor registered");
		Smanager.registerListener((SensorEventListener) this, sensor,SensorManager.SENSOR_DELAY_NORMAL);
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		Log.v("LEE", "Sensor Unregisterd");
		Smanager.unregisterListener(this);
		super.onPause();
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		//Log.v("LEE", "sensor value changed");
		//float val = event.values[0];
		if(event.sensor.getType()==Sensor.TYPE_LINEAR_ACCELERATION){
			float x = event.values[0];
			float y = event.values[1];
			if(y<0){
				y=y*-1;
			}
			float z = event.values[2];
			if((y-yprev)>threshold){
				steps++;
				Log.v("LEE", "Steps : "+steps);
				step.setText("steps :"+steps);
				seekthreshold.setText("Threshold set to : "+threshold);
			}
			coordinates.setText("X :"+x+
					"\nY: "+y+
					"\nZ: "+z);
			yprev=y;
		}
		if(event.sensor.getType()==Sensor.TYPE_ROTATION_VECTOR){
				float mAzimuth = event.values[0];
	            float mPitch = event.values[1];
	            float mRoll = event.values[2];

	            Log.d("rotate","mAzimuth :"+mAzimuth);
	            Log.d("rotate","mPitch :"+mPitch);
	            Log.d("rotate","mRoll :"+mRoll);
	        
		}
		
	}
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		Log.v("LEE", "sensor accuracy changed");
		
	}

	@Override
	public void onClick(View arg0) {
		steps=0;
		step.setText("steps : 0");
		
	}


	
    @Override
     public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
    	threshold=progresValue;
    	seekthreshold.setText("Threshold set to : "+threshold);
         Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
     }
     @Override
     public void onStartTrackingTouch(SeekBar seekBar) {
         Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
     }
     @Override
     public void onStopTrackingTouch(SeekBar seekBar) {
         Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
     }


}
