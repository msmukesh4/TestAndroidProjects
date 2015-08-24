package com.example.fragmentcomm;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentA  extends Fragment implements OnClickListener{

	Communicator comm;
	Button b;
	int times=0;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		if (savedInstanceState==null) {
			times=0;
		}else{
			times=savedInstanceState.getInt("counter",0);
		}
		
		return inflater.inflate(R.layout.fragment_a, container, false);
		
		
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		comm = (Communicator) activity;
		super.onAttach(activity);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		b= (Button) getActivity().findViewById(R.id.button1);
		b.setOnClickListener(this);
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		
		outState.putInt("counter", times);
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		times++;
		comm.respond("Clicked on button "+times+" times");
		
	}
	
}
