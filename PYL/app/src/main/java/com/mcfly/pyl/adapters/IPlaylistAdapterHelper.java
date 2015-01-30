package com.mcfly.pyl.adapters;

import android.content.Context;
import android.database.Cursor;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

/**
 * Created by mcfly on 08/01/2015.
 */
public interface IPlaylistAdapterHelper {

    public BaseAdapter getPlayListAdapter(Context context, Cursor cursor);

}
