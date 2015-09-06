package com.example.botique_listview;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	// This is the provideString Json_url="";
	String Json_url;
	ImageView icon;
	TextView item;
	ListView list_of_items;
	Thread download;
	String Json_data_string;
	String JSON;
	ArrayList<String> names,images,ids;
	int size =0;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Json_data_string ="{\"Employee\" :[{\"id\":\"01\",\"name\":\"Earth\",\"image\":\"R.drawable.earth\"},{\"id\":\"02\",\"name\":\"Uranus\",\"image\":\"R.drawable.uranus\"},{\"id\":\"03\",\"name\":\"Venus\",\"image\":\"R.drawable.venus\" }] }";
        Json_url= "http://www.boutiqueplatter.com/oc_phonephp/boutiques.php?mode=nearlist&search_data=&longitude=88.3579206&latitude=22.557878199999998&count=50&version=1";
    	
        //constructing UI objects
       
       
        list_of_items = (ListView) findViewById(R.id.listView1);       
        names = new ArrayList<String>();
        images = new ArrayList<String>();
        ids = new ArrayList<String>();
        downloadJSON();
        parseJson();
        
        
        list_of_items.setAdapter(new myAdapter(this));              
    }
    
    protected void parseJson() {
		// TODO Auto-generated method stub
    	try{
    		JSONObject root =  new JSONObject(Json_data_string);
    		JSONArray jsonArray = root.optJSONArray("Employee");
    		Log.v("test", ""+jsonArray);
    		for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				String name = obj.optString("name").toString();
				String image = obj.optString("image").toString();
				String id = obj.optString("id").toString();
				names.add(name);
				images.add(image);
				ids.add(id);
				size++;
				Log.v("test", "name is "+i+" "+name+" image "+image);
			}
    		
    		
    		
    	}catch(Exception ee){
    		ee.printStackTrace();
    	}
	}

	//Download the JSON and store it in the form of a string..
    // i.e. Json_data_string
    void downloadJSON() {    	    	    	
    		download = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try{
						// TODO Auto-generated method stub				
						HttpClient client = new DefaultHttpClient();
				    	HttpGet http_get = new HttpGet(Json_url);
						HttpEntity httpEntity = client.execute(http_get).getEntity();
			    		InputStream is = httpEntity.getContent();
			    		Reader reader = new InputStreamReader(is);
			    		BufferedReader buffered_reader = new BufferedReader(reader);
			    		StringBuilder string_builder = new StringBuilder();
			    		
			    		String temp = null ; 
			    		
			    		while((temp= buffered_reader.readLine())!= null){
			    			string_builder.append(temp + "\n");
			    		}
			    		JSON = string_builder.toString();
			    		Log.v("test","JSON :: "+JSON);
					}catch(Exception ee){
			    		ee.printStackTrace();
			    	}
				}
    		});
    		download.start();
	}
    
    class myAdapter extends BaseAdapter{
    	
    	LayoutInflater inflater;
    	ImageView iv;
    	TextView tv;
    	myAdapter(Context context){
    		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	}
    	
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return size;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return names.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View row = convertView;
		 	row =  inflater.inflate(R.layout.individual_item, parent, false);
			
			ImageView iv = (ImageView) row.findViewById(R.id.image);
			TextView tv = (TextView) row.findViewById(R.id.name);
			TextView id_obj = (TextView) row.findViewById(R.id.id);
			TextView image_obj = (TextView) row.findViewById(R.id.image_name);
			
			if (images.get(position).equalsIgnoreCase("R.drawable.earth")) {
				iv.setImageResource(R.drawable.earth);
			}else if (images.get(position).equalsIgnoreCase("R.drawable.uranus")) {
				iv.setImageResource(R.drawable.uranus);
			}else if (images.get(position).equalsIgnoreCase("R.drawable.venus")) {
				iv.setImageResource(R.drawable.venus);
			}
			tv.setText(names.get(position));
			id_obj.setText(ids.get(position));
			image_obj.setText(images.get(position));
			
			return row;
		}
    }

    
}
