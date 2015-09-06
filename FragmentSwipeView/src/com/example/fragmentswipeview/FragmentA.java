package com.example.fragmentswipeview;

/*
 * Steps on creating a new fragment 
 * -------------------------------
 * 0. Extend the class by fragment
 * 1. onCreateView should be override, which is called when the 
 * 		fragment is created.
 * 2. Return the fragment and inflate it with layout.
 * 
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentA extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_a_layout, container, false);
	}

	
}
