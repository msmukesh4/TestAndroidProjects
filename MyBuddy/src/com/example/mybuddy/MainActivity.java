package com.example.mybuddy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity {
    InputStream inputStream;
    String res = "";
    ArrayList<NameValuePair> nameValuePairs;
    String the_string_response;
    int contentLength;
    TextView tv1,tv2;
    
        @Override
    public void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            setContentView(R.layout.activity_main);
 
            tv1= (TextView) findViewById(R.id.textView1);
            tv2 = (TextView) findViewById(R.id.textView2);
            
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);           
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream); //compress to which format you want.
            byte [] byte_arr = stream.toByteArray();
            String image_str = Base64.encodeBytes(byte_arr);
            nameValuePairs = new  ArrayList<NameValuePair>();
 
            nameValuePairs.add(new BasicNameValuePair("image",image_str));
 
             Thread t = new Thread(new Runnable() {
             
            @Override
            public void run() {
                  try{
                         HttpClient httpclient = new DefaultHttpClient();
                         HttpPost httppost = new HttpPost("http://webserver123.esy.es/Images/uploadImages.php");
                         httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                         HttpResponse response = httpclient.execute(httppost);
                         the_string_response = convertResponseToString(response);
                         runOnUiThread(new Runnable() {
                                 
                                @Override
                                public void run() {
                                	if (contentLength==-1) {
										tv1.setText("Upload Successful");
										tv2.setVisibility(View.GONE);
										Toast.makeText(MainActivity.this,"Image Uploaded Successfully !!", Toast.LENGTH_LONG).show();
										
									}
                                    	Toast.makeText(MainActivity.this, "Response " + the_string_response, Toast.LENGTH_LONG).show();
                                    	
									
                                }
                            });
                          
                     }catch(final Exception e){
                          runOnUiThread(new Runnable() {
                             
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "ERROR " + e.getMessage(), Toast.LENGTH_LONG).show();
                                e.printStackTrace();
                            }
                        });       
                     }  
            }
        });
         t.start();
        }
 
        public String convertResponseToString(HttpResponse response) throws IllegalStateException, IOException{
 
            
             StringBuffer buffer = new StringBuffer();
             inputStream = response.getEntity().getContent();
             contentLength = (int) response.getEntity().getContentLength(); //getting content length…..
              runOnUiThread(new Runnable() {
             
            	  @Override
            	  public void run() {
	            	
	                Toast.makeText(MainActivity.this, "contentLength : " + contentLength, Toast.LENGTH_LONG).show();                     
            	  }
              });
          
             if (contentLength < 0){
             }
             else{
                    byte[] data = new byte[512];
                    int len = 0;
                    try
                    {
                        while (-1 != (len = inputStream.read(data)) )
                        {
                            buffer.append(new String(data, 0, len)); //converting to string and appending  to stringbuffer…..
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    try
                    {
                        inputStream.close(); // closing the stream…..
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    res = buffer.toString();     // converting stringbuffer to string…..
 
                    runOnUiThread(new Runnable() {
                     
                    @Override
                    public void run() {
                       Toast.makeText(MainActivity.this, "Result : " + res, Toast.LENGTH_LONG).show();
                       tv2.setText(" Result //"+res);
                    }
                });
                    //System.out.println("Response => " +  EntityUtils.toString(response.getEntity()));
             }
             return res;
        }
}