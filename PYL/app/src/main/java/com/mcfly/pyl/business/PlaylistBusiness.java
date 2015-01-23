package com.mcfly.pyl.business;

import android.content.Context;
import android.database.Cursor;

import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.sqlite.dao.extended.PlaylistDAO;

/**
 * Created by mcfly on 08/01/2015.
 */
public class PlaylistBusiness {

    private final Context context;

    public PlaylistBusiness(Context context) {
        this.context = context;
    }

    public Cursor getPlaylist() {
        PlaylistDAO playlistDAO = new PlaylistDAO(context);
        return playlistDAO.getPlaylists();
    }
}
