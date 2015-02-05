package com.mcfly.pyl;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.mcfly.pyl.business.ContactListBusiness;
import com.mcfly.pyl.fragments.PlaylistSongsFragment;
import com.mcfly.pyl.menu.MainMenu;
import com.mcfly.pyl.menu.MainPagerAdapter;
import com.mcfly.pyl.fragments.PlaylistFragment;
import com.mcfly.pyl.sqlite.DbManager;
import com.mcfly.pyl.sqlite.dal.Playlist;


public class MainActivity extends Activity implements ActionBar.TabListener, PlaylistFragment.OnFragmentInteractionListener, IPlaylistActions {

    private final static String TAG = MainActivity.class.getName();

    MainPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mSectionsPagerAdapter = new MainPagerAdapter(getFragmentManager(), this);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        initMenu();

        //Fill test database
       //DbManager.getInstance(this).executeTestFile();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if ( id == R.id.action_contacts) {
            bindContactList();
            return true;
        } else if (id == R.id.action_create_playlist) {
            bindCreatePlaylist();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }


    private void initMenu() {
        final ActionBar actionBar = getActionBar();

        for(MainMenu menu : MainMenu.values()) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(getResources().getString(menu.getTitle()))
                            .setTabListener(this));
        }
    }

    @Override
    public void onFragmentInteraction(String id) {

    }

    /////////////////////////////////////////////////////////////////////////////////////////

    private void bindContactList() {
        Intent intent = new Intent(this, ContactListActivity.class);
        startActivity(intent);
    }

    private void bindCreatePlaylist() {
        Intent intent = new Intent(this, CreatePlaylistActivity.class);
        startActivity(intent);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    ///// IPlaylistActions
    ////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void showPlaylist(Playlist playlist) {
        Fragment fragment = new PlaylistSongsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(PlaylistSongsFragment.KEY_PLAYLIST_OBJECT,playlist);
        fragment.setArguments(bundle);
        mSectionsPagerAdapter.switchFragment(mViewPager.getCurrentItem(), fragment);
    }

    /////////////////////////////////////////////////////////////////////////////////////////


}
