package com.example.autocompletetextviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity {
	
	int initial=0,init=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       
        // populating the list view  with String values
        String[] Places = {"Lucknow","Kolkata","Jammu & Kashmir","Banglore","Hydrabad","Pune","Paradip","Ludhiyana","Burla","Belaghat"}; 
        final AutoCompleteTextView autocompletetextview = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        final MultiAutoCompleteTextView multiautocompletetextview = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        
        
        // adapter to get set the layout of various strings
        autocompletetextview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Places));
        multiautocompletetextview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Places));
        
        
        //this will fix the token in detween various strings in the text
        multiautocompletetextview.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        
        //clear the text in the edit text space when ever the user taps for the first time
        multiautocompletetextview.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				if (init == 0) {
					multiautocompletetextview.setText("");
					init++;
				}
				
			}
		});
        
        
        //clear the text in the edit text space when ever the user taps for the first time
        autocompletetextview.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				if (initial == 0) {
					autocompletetextview.setText("");
					initial++;
				}
				
			}
		});
        
        // value 1 :: means it will start generating list from the very first character input
        autocompletetextview.setThreshold(1);
        multiautocompletetextview.setThreshold(1);
    }
    
}
