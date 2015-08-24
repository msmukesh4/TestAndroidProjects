package com.example.fragmentcomm;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment{

	String data;
	TextView tv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view= inflater.inflate(R.layout.fragment_b, container, false);
		TextView tv2 = (TextView) view.findViewById(R.id.textView1);
		
		if (savedInstanceState==null) {
			
		}else{
			data = savedInstanceState.getString("clicked");
			tv2.setText(data);
		}
		
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		tv = (TextView) getActivity().findViewById(R.id.textView1);
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		outState.putString("clicked", data);
		
		super.onSaveInstanceState(outState);
	}
	
	public void changeData(String s){
		data=s;
		tv.setText(s);
	}
}
