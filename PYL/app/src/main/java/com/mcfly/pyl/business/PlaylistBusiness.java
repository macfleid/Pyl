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
    private PlaylistDAO playlistDAO;

    public PlaylistBusiness(Context context) {
        this.context = context;
        playlistDAO = new PlaylistDAO(context);
    }

    public Cursor getPlaylist() { return playlistDAO.getPlaylists(); }

    public Cursor getPlaylist_shared() {  return playlistDAO.getSharedPlaylists() ; }

    public Cursor getPlaylist_favorites() {
        return playlistDAO.getFavoritesPlaylists();
    }

    public Cursor getPlaylist_mines() {
        return playlistDAO.getMyPlaylists();
    }

    public Cursor getPlaylistSongs(Playlist playlist) { return playlistDAO.getPlaylistSongsView(playlist);  }

}
