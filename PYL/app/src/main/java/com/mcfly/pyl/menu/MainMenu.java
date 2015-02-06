package com.mcfly.pyl.menu;

import android.app.Fragment;
import android.os.Bundle;

import com.mcfly.pyl.R;
import com.mcfly.pyl.fragments.PlaylistFragment;

/**
 * Created by mcfly on 02/01/2015.
 */
public enum MainMenu {

    SHARED(R.string.menu_shared, new PlaylistFragment()),
    MINES(R.string.menu_mines, new PlaylistFragment()),
    FAVORITES(R.string.menu_favorites, new PlaylistFragment());

    private int title;
    private Fragment fragment;

    private MainMenu(int res, Fragment fragment) {
        this.title = res;
        this.fragment = fragment;
        Bundle bundle = new Bundle();
        bundle.putSerializable(PlaylistFragment.PLAYLIST_LIST_MODE, this);
        this.fragment.setArguments(bundle);
    }

    public int getTitle() {
        return title;
    }

    public Fragment getFragment() {
        return fragment;
    }

}
