package com.cs329E.blitz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;

import com.cs329E.blitz.Fragments.SelectEventFragment;
import com.cs329E.blitz.Fragments.MyInvitationsFragment;

public class MainScreenActivity extends FragmentActivity {
	
	private static final String TAG = "Main Screen Activity";
	FragmentPagerAdapter adapterViewPager;
	
    public static class MyPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return SelectEventFragment.newInstance(0, "Select Event");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return MyInvitationsFragment.newInstance(1, "My Invitations");
            default:
                return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);
				
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
		
    	// Attach the page change listener inside the activity
    	vpPager.setOnPageChangeListener(new OnPageChangeListener() {

    	    // This method will be invoked when a new page becomes selected.
    	    @Override
    	    public void onPageSelected(int position) {
//    	        Toast.makeText(SelectEventActivity.this, 
//    	                    "Selected page position: " + position, Toast.LENGTH_SHORT).show();
    	    }

    	    // This method will be invoked when the current page is scrolled
    	    @Override
    	    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    	        // Code goes here
    	    }

    	    // Called when the scroll state changes: 
    	    // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
    	    @Override
    	    public void onPageScrollStateChanged(int state) {
    	        // Code goes here
    	    }
    	});
        


			
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blitz_selection, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onBackPressed() {
	  super.onBackPressed();
	  overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	}
	
}
