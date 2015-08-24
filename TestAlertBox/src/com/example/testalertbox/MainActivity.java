package com.example.testalertbox;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button b = (Button) findViewById(R.id.button1);
		final TextView tv = (TextView) findViewById(R.id.textView1);
		
		new AlertDialog.Builder(this)
		.setTitle("Storing contact")
		.setMessage("Do you want to store Mukesh in phonebook")
		.setIcon(android.R.drawable.ic_dialog_alert)
		.setPositiveButton("YES", new DialogInterface.OnClickListener() {

		    public void onClick(DialogInterface dialog, int whichButton) {
		       tv.setText("Clicked yes");
		    }})
		 .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				tv.setText("Clicked no");
				
			}
		}).show();
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				recreate();
				
			}
		});
		
		
	}
	

}
