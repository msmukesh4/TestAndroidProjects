package com.example.fragmentwithlistview;

import android.R.array;
import android.R.raw;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentA extends Fragment implements OnItemClickListener{
	
	Communicator comm;
	ListView listview;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragmenta_layout, container,false);
		
		return view;
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
		listview = (ListView) getActivity().findViewById(R.id.listView1);
		listview.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.list)));
		listview.setOnItemClickListener(this);
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		comm.respond(arg2);
		
	}

}
