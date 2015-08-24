package com.example.custom_list_from_url;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;

import com.example.custom_list_from_url.MainActivity.countries;

import android.R.string;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener{

	ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		listview =  (ListView) findViewById(R.id.listView1);
		listview.setAdapter(new myAdapter(this));
	}

	class countries{
		String imageview;
		String textview;
		public countries(String iv, String tv) {
			imageview=iv;
			textview=tv;
		}
	}
	
	class myHolder{
		TextView tv;
		ImageView iv;
		public myHolder(View v) {
			tv= (TextView) v.findViewById(R.id.textView1);
			iv =  (ImageView) v.findViewById(R.id.imageView1);
		}
	}
	
	class myAdapter extends ArrayAdapter<String>{

		countries country_list;
		LayoutInflater li;
		String[] urls;
		String[] tag;
	    ArrayList<countries> listdata;
		
		public myAdapter(Context context){
			listdata =  new ArrayList<countries>();
			urls= getResources().getStringArray(R.array.images_array);
			tag = getResources().getStringArray(R.array.headline_array);
			for(int i=0;i<urls.length;i++){
			    country_list = new countries(urls[i], tag[i]);
				listdata.add(country_list);
		}
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			myHolder holder=null;
			if (row==null) {
				li = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				row = li.inflate(R.layout.my_layout, parent, false);
				holder = new myHolder(row);
				row.setTag(holder);
			}
			else {
				holder = (myHolder) row.getTag();
			}
			countries obj = listdata.get(position);
			
			if (holder.iv!=null) {
				new ImageDownloaderTask(holder.iv).execute(urls[position]);
			}
			holder.tv.setText(tag[position]);
			holder.iv.setTag(obj);
			
			
			return row;
		}
		
	}
	class ImageDownloaderTask extends AsyncTask<String, Void, Bitmap> {
	    private final WeakReference<ImageView> imageViewReference;

	    public ImageDownloaderTask(ImageView imageView) {
	        imageViewReference = new WeakReference<ImageView>(imageView);
	    }

	    @Override
	    protected Bitmap doInBackground(String... params) {
	        return downloadBitmap(params[0]);
	    }

	    @Override
	    protected void onPostExecute(Bitmap bitmap) {
	        if (isCancelled()) {
	            bitmap = null;
	        }

	        if (imageViewReference != null) {
	            ImageView imageView = imageViewReference.get();
	            if (imageView != null) {
	                if (bitmap != null) {
	                    imageView.setImageBitmap(bitmap);
	                } else {
	                    Drawable placeholder = imageView.getContext().getResources().getDrawable(R.drawable.ic_launcher);
	                    imageView.setImageDrawable(placeholder);
	                }
	            }
	        }
	    }
	}
	private Bitmap downloadBitmap(String url) {
	    HttpURLConnection urlConnection = null;
	    try {
	        URL uri = new URL(url);
	        urlConnection = (HttpURLConnection) uri.openConnection();
	        int statusCode = urlConnection.getResponseCode();
	        if (statusCode != HttpStatus.SC_OK) {
	            return null;
	        }

	        InputStream inputStream = urlConnection.getInputStream();
	        if (inputStream != null) {
	            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
	            return bitmap;
	        }
	    } catch (Exception e) {
	        urlConnection.disconnect();
	        Log.v("ImageDownloader", "Error downloading image from " + url);
	    } finally {
	        if (urlConnection != null) {
	            urlConnection.disconnect();
	        }
	    }
	    return null;
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent it =  new Intent(this, Dialog_activity.class);
		
	}

}
