package com.example.fusedlocationprovider;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements LocationListener,ConnectionCallbacks{

	private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
	Location loc;
	double var_latitude,var_longitude;
	Button update;
	TextView tv_lat,tv_long;
	LocationRequest locationRequest;
	GoogleApiClient mGoogleApiClient;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv_lat = (TextView) findViewById(R.id.latitude);
        tv_long = (TextView) findViewById(R.id.longitude);
        update = (Button) findViewById(R.id.btn_Update);
        
        //connect the google API client if
        // if connected will call onConnected()
        // if failed will call onConnectionSuspended() 
        mGoogleApiClient =   new GoogleApiClient.Builder(this)
        .addApi(LocationServices.API)
        .addConnectionCallbacks(this)
        .build();
        
        if (mGoogleApiClient != null) {
			Toast.makeText(this, "Google APi Client Initialised", Toast.LENGTH_SHORT).show();
			 mGoogleApiClient.connect();
		}else{
			Toast.makeText(this, "Google APi Client Initialisation Failed", Toast.LENGTH_SHORT).show();
			finish();
		}
     
        /*
         * To store the parameters for request to fused location Provider 
         * We need a create a 'locationRequest' object that will set he levels 
         * 
         * NOTE :: make sure the WIfi  and Internet is enabled in your Device
         */
        
        locationRequest = new LocationRequest();
    	locationRequest.setInterval(5000);
    	locationRequest.setFastestInterval(1000);
    	locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        
       
        /*
    	 * Request location from location services from
    	 * google's 'FusedLocationApi' 
    	 *  parameters are GoogleAPICient,locationRequest object and location Listener
    	 */
    	update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Updating Location...", Toast.LENGTH_LONG).show();
				boolean b =  checkPlayServices();
				if(b){
					Toast.makeText(getApplicationContext(), "Play Services Available", Toast.LENGTH_SHORT).show();
					startLocationUpdates();
				}else{
					Toast.makeText(getApplicationContext(), "Play Services Not Available", Toast.LENGTH_SHORT).show();
				}
			}
		});
    	    	        
    }
    
    
    //Unregister the Location Updater when activity is pause
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
    	super.onPause();
    }
    
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }
        return true;
    }
	
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		Log.v("location","Location Changed");
		loc=location;	
		if (loc!=null) {
			var_latitude=loc.getLatitude();
			var_longitude=loc.getLongitude();
			tv_lat.setText(""+var_latitude);
			tv_long.setText(""+var_longitude);
		}else{
			tv_lat.setText("-------");
			tv_long.setText("-------");
		}
		
	}
	
	public void startLocationUpdates(){
		LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest,this);
	}

	@Override
	public void onConnected(Bundle arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"Google API Client Connected", Toast.LENGTH_LONG).show();
		loc = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
		if (loc!=null) {
			Toast.makeText(getApplicationContext(), "LastKnownLocation is Available", Toast.LENGTH_SHORT).show();
			var_latitude=loc.getLatitude();
			var_longitude=loc.getLongitude();
			tv_lat.setText(""+var_latitude);
			tv_long.setText(""+var_longitude);
		}else{
			Toast.makeText(getApplicationContext(), "LastKnownLocation is null", Toast.LENGTH_SHORT).show();

		}
	}

	@Override
	public void onConnectionSuspended(int arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"Google API Client Not Connected", Toast.LENGTH_LONG).show();
	}
}
