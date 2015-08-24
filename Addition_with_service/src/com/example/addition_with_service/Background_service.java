package com.example.addition_with_service;

import com.example.addition_with_service.Addition;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class Background_service extends Service {

	public IBinder onBind(Intent intent){
		Log.v("LEE", "background Bindind service");
		return binder;
	}

	/**
	 * IAdd definition is below
	 */
	private final Addition.Stub binder = new Addition.Stub() {

		@Override
		public int add(int num1, int num2) throws RemoteException {
			// TODO Auto-generated method stub
			Log.v("LEE", "background addition method is called");
			return (num1 + num2);
		}

	};
}
