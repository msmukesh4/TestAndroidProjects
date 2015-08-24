package com.example.download_image_from_url;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	 Thread th;
	ImageView iv;
	Bitmap bitmap;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 iv = (ImageView) findViewById(R.id.imageView1);
		
		 try{
		th= new Thread(new Runnable() {
			
			@Override
			public void run() {
				 bitmap=loadimage();
				 Log.v("bitmap", "bitmap : "+bitmap);
				 
				 runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						
						 iv.setImageBitmap(bitmap);
					}
				});
			}
		});
		 }catch(Exception ee)
		 {ee.printStackTrace();}
		 th.start();
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		th.stop();
		super.onDestroy();
	}
	private Bitmap loadimage() {
		HttpURLConnection conn = null;
		try{
		String  url="http://tile.openstreetmap.org/16/32720/21795.png";
		URL url_var = new URL(url);
		
		conn = (HttpURLConnection) url_var.openConnection();
		conn.setDoInput(true);
		conn.connect();
		InputStream is = conn.getInputStream();
		Bitmap bitmap= BitmapFactory.decodeStream(is);		
			if(bitmap!=null)
				return bitmap;
			
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			conn.disconnect();
		}
		return null;
	}
}
