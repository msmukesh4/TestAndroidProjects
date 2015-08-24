package com.example.fragment_scroll_view_pager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	ViewPager viewpager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewpager = (ViewPager) findViewById(R.id.pager);
		FragmentManager manager = getSupportFragmentManager();
		viewpager.setAdapter(new myAdapter(manager));
	}

}

class myAdapter extends FragmentPagerAdapter{

	public myAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int i) {
		// TODO Auto-generated method stub
		Fragment fragment = null;
		if (i==0) {
			fragment = new FragmentA();
			
		}
		else if (i==1) {
			fragment = new FragmentB();
		}
		else if (i==2) {
			fragment = new FragmentC();
			
		}
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		//String string = new String();
		if (position==0) {
			return "Tab 1";
		}else if (position==1) {
			return "Tab 2";
			
		}else if (position==2) {
			return "Tab 3";
		}
		else return null;
	}
}