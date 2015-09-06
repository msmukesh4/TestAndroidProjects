package com.example.fragmentswipeview;

/*
 * Fragment Swipe view
 * We are going to make tabs in the Action bar and whenever the user clicks on any of the tabs
 * it takes them to a specific fragment according to the tab selected and implement the swipe views 
 * whenever the user swipes between fragments.
 * 
 * Steps
 * ------
 * 0. extend FragmentActivity
 * 1. Create an Objects to action bar
 * 2. Specify that tabs should be displayed in the action bar.
 * 3. Add Listener to Action Bar  this is called when the user changes tabs...
 * 4. Add number of tabs, specifying the tab's text and TabListener
 * 5. Initialize the view pager that will contain all the fragments.
 * 6. Set Adapter to view Pager
 * 7. Create another class that extends from FragmentPageAdaper this is going 
 * 		to specify the fragments that will be shown with respective tabs.
 * 8.change the action bar tab when swipe event is performed
 */


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
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainActivity extends FragmentActivity {

	//5. Initialize the View pager
	ViewPager viewpager;
	ActionBar actionBar;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//6. Set adapter to view pager
		FragmentManager manager = getSupportFragmentManager();
		viewpager = (ViewPager) findViewById(R.id.pager);
		viewpager.setAdapter(new myAdapter(manager));			
		
		// 1. Create an Object of Action Bar
		actionBar = getActionBar();
		
		// 2. Specify that tabs should be displayed in the action bar.
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		//3. Add Listener to Action Bar  this is called when the user changes tabs...
		ActionBar.TabListener tabListner = new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Tab "+tab+"Selected", Toast.LENGTH_LONG).show();
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Tab "+tab+"Selected", Toast.LENGTH_LONG).show();
				viewpager.setCurrentItem(tab.getPosition());

			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Tab "+tab+"Selected", Toast.LENGTH_LONG).show();

			}
		};
		
		
		viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			/**
			 * on swiping the viewpager make respective tab selected
			 * */
			
			
			@Override
			public void onPageSelected(int pos) {
				// TODO Auto-generated method stub
				actionBar.setSelectedNavigationItem(pos);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		 // 4. Add number of tabs, specifying the tab's text and TabListener
		for (int i = 1; i <=3; i++) {
			actionBar.addTab(
					actionBar.newTab()
						.setText("Tab :"+i)
						.setTabListener(tabListner)
			);
		}
		
		
	}

	
	class myAdapter extends FragmentPagerAdapter{

		public myAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		// get item always return a fragment when ever its being called and is
		// used to create  new fragment each time which are added to the ViewPager.
		
		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			Fragment fragment =null;
			if (position==0) {
				fragment = new FragmentA();
			}else if (position==1) {
				fragment = new FragmentB();
			}else if (position==2) {
				fragment = new FragmentC();
			}else
				fragment = null;
			return fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}
		
	}
}
