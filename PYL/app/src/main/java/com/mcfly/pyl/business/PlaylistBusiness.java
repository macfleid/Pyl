package com.mcfly.pyl.business;

import android.content.Context;
import android.database.Cursor;

import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.sqlite.dal.Song;
import com.mcfly.pyl.sqlite.dao.extended.PlaylistDAO;

import java.util.ArrayList;
import java.util.List;

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

    public Cursor getPlaylist_shared() {
        return null;
    }

    public Cursor getPlaylist_favorites() {
        return null;
    }

    public Cursor getPlaylist_mines() {
        return null;
    }

    public Cursor getPlaylistSongs(Playlist playlist) {
        PlaylistDAO playlistDAO = new PlaylistDAO(context);
        Cursor cursor = playlistDAO.getPlaylistSongsView(playlist);
        return cursor;
    }



}
