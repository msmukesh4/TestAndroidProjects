package com.example.android_additionservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.android_additionservice.IAdd;

public class AdditionService extends Service {

	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}

	/**
	 * IAdd definition is below
	 */
	private final IAdd.Stub mBinder = new IAdd.Stub() {

		@Override
		public int add(int num1, int num2) throws RemoteException {
			// TODO Auto-generated method stub
			return (num1 + num2);
		}

	};
}
