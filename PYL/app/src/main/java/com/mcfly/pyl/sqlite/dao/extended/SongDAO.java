package com.mcfly.pyl.sqlite.dao.extended;

import android.content.Context;
import com.mcfly.pyl.sqlite.dal.wrapper.SongDalWrapper;

import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.mcfly.pyl.sqlite.contentprovider.SongContentProvider;
import com.mcfly.pyl.sqlite.dao.BaseDAO;
import com.mcfly.pyl.sqlite.dal.Song;
import com.mcfly.pyl.sqlite.dao.extended.interfaces.ISong;

public class SongDAO extends BaseDAO implements ISong {

    private final static String TAG = SongDAO.class.getName();

    public SongDAO(Context c) {
        super(c, SongContentProvider.CONTENT_URI);
        Log.d(TAG, "#SongDAO");    }

    @Override
    public int save(Song element) {
       int result = add(SongDalWrapper.getContentValueFromObject(element));
       return result;
    }
}
