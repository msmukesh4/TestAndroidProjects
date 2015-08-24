package com.example.fragmentwithlistview;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

	String[] details;
	TextView tv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragmentb_layout,container, false);
		return view;
		
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		tv = (TextView) getActivity().findViewById(R.id.textView1);
		details = getResources().getStringArray(R.array.detais);
		super.onActivityCreated(savedInstanceState);
	}
	
	public void sendData(int index){
		tv.setText(details[index]);
	}

}
