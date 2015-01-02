package com.mcfly.pyl.menu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;

import com.mcfly.pyl.MainActivity;

import java.util.Locale;

/**
 * Created by mcfly on 02/01/2015.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public MainPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        MainMenu[] values = MainMenu.values();
        return values[position].getFragment();
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
}
