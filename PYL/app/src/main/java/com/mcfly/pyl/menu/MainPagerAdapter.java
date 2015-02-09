package com.mcfly.pyl.menu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.mcfly.pyl.MainActivity;

import java.util.Locale;

/**
 * Created by mcfly on 02/01/2015.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private final static String TAG = MainPagerAdapter.class.getName();

    private Context context;

    private boolean forceRefresh;
    private int refreshedPosition;
    private Fragment refreshedFragment;

    public MainPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        forceRefresh = false;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "   [getItem] on position "+position);
        if(forceRefresh && position==refreshedPosition) {
            Log.d(TAG, "      [forceRefresh] on position "+position);
            forceRefresh = false;
            return refreshedFragment;
        }
        MainMenu[] values = MainMenu.values();

        return values[position].getFragment();
    }

    @Override
    public int getItemPosition(Object object) {
        Log.d(TAG, "[getItemPosition]");
        if(forceRefresh) {
            Log.d(TAG, " -->[POSITION_NONE]");
            return POSITION_NONE ;
        }
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return MainMenu.values().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return context.getResources().getString(MainMenu.SHARED.getTitle()).toUpperCase(l);
            case 1:
                return context.getResources().getString(MainMenu.MINES.getTitle()).toUpperCase(l);
            case 2:
                return context.getResources().getString(MainMenu.FAVORITES.getTitle()).toUpperCase(l);
        }
        return null;
    }

    public void switchFragment(int position, Fragment fragment) {
        Log.d(TAG, "[switchFragment] position:"+position);
        forceRefresh = true ;
        refreshedPosition = position;
        refreshedFragment = fragment;
        this.notifyDataSetChanged();
    }

    public void refreshPosition(int position) {
        if(position < 0 || position > this.getCount()) {
            return;
        }
        switchFragment(position, MainMenu.values()[position].getFragment());
    }
}
