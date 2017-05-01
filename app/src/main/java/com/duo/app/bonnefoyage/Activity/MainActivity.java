package com.duo.app.bonnefoyage.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.duo.app.bonnefoyage.Activity.data.Database;
import com.duo.app.bonnefoyage.Activity.data.IBonneRepo;
import com.duo.app.bonnefoyage.Activity.fragment.CityFragment;
import com.duo.app.bonnefoyage.Activity.fragment.NearbyFragment;
import com.duo.app.bonnefoyage.Activity.fragment.VisitedLocationsFragment;
import com.duo.app.bonnefoyage.R;
import com.duo.app.bonnefoyage.domein.City;
import com.duo.app.bonnefoyage.domein.User;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    /**
     * The user class with all info needed for application.
     */
    private User user;

    private IBonneRepo dataRepo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataRepo = Database.getDataInstance();
        //testing here
        user = dataRepo.getUser("test@test.com");

        City city = dataRepo.getCity("NewYork");
        City city2 = dataRepo.getCity("Eindhoven");
        user.addRecommendation(city);
        user.addRecommendation(city2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        //todo: get user email from intent, get actual user from database. For now use test user.

        //todo: calculate recommended cities based on user. make interface for a Recommender class.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Bundle fragmentBundle = new Bundle();
            fragmentBundle.putSerializable("user", user);

            dataRepo.putUser(user);
            fragmentBundle.putString("email", user.getEmail());
            Fragment fragment;
            switch (position){
                case 0:
                    fragment = new CityFragment();
                    break;
                case 1:
                    fragment = new NearbyFragment();
                    break;
                case 2:
                    fragment = new VisitedLocationsFragment();
                    break;
                default:
                    fragment = new CityFragment();
                    break;
            }
            fragment.setArguments(fragmentBundle);
            return fragment;
            //TODO: make layouts for each fragment. <strike>CityFragment</strike>, NearbyFragment.
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        /**
         * Specifies the name for each tab.
         * @param position the position to get name of.
         * @return the name as charSequence
         */
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Cities";
                case 1:
                    return "Nearby";
                case 2:
                    return "History";
            }
            return null;
        }

    }
}
