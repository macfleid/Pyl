package com.mcfly.pyl.sqlite.dao.extended;

import android.content.Context;
import com.mcfly.pyl.sqlite.utils.KLog;import com.mcfly.pyl.sqlite.dal.wrapper.PlaylistDalWrapper;

import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.mcfly.pyl.sqlite.contentprovider.PlaylistContentProvider;
import com.mcfly.pyl.sqlite.dao.BaseDAO;
import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.sqlite.dao.extended.interfaces.IPlaylist;

public class PlaylistDAO extends BaseDAO implements IPlaylist {

    private final static String TAG = PlaylistDAO.class.getName();

    public PlaylistDAO(Context c) {
        super(c, PlaylistContentProvider.CONTENT_URI);
        KLog.d(c,TAG, "#PlaylistDAO");    }

    @Override
    public int save(Playlist element) {
       int result = add(PlaylistDalWrapper.getContentValueFromObject(element));
       return result;
    }
}
