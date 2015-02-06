package com.mcfly.pyl.sqlite.dao.extended;

import android.content.Context;

import com.mcfly.pyl.sqlite.dal.Contact;
import com.mcfly.pyl.sqlite.dal.Song;
import com.mcfly.pyl.sqlite.dal.wrapper.PlaylistDalWrapper;

import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.mcfly.pyl.sqlite.contentprovider.PlaylistContentProvider;
import com.mcfly.pyl.sqlite.dao.BaseDAO;
import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.sqlite.dao.extended.interfaces.IPlaylist;
import com.mcfly.pyl.sqlite.views.wrapper.Playlist_listDalWrapper;

import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO extends BaseDAO implements IPlaylist {

    private final static String TAG = PlaylistDAO.class.getName();

    public PlaylistDAO(Context c) {
        super(c, PlaylistContentProvider.CONTENT_URI);
        Log.d(TAG, "#PlaylistDAO");    }

    @Override
    public int save(Playlist element) {
       int result = add(PlaylistDalWrapper.getContentValueFromObject(element));
       return result;
    }

    @Override
    public Cursor getPlaylists() {
        Cursor cursor = this.context.getContentResolver().query(
                PlaylistContentProvider.PLAYLIST_URI,
                null,
                null,
                null,
                null);
        return cursor;
    }

    public List<Playlist> getPlayLists() {
        Cursor cursor = this.context.getContentResolver().query(
                PlaylistContentProvider.PLAYLIST_URI,
                null,
                null,
                null,
                null);
        ArrayList<Playlist> result = new ArrayList<Playlist>();
        if(cursor==null || !cursor.moveToFirst()) {
            return result;
        }
        do {
            Playlist playlist = Playlist_listDalWrapper.getPlaylist(cursor);
            result.add(playlist);
        } while(cursor.moveToNext());
        cursor.close();
        Log.d(TAG, "NbFound::"+cursor.getCount());
        return result;
    }

    @Override
    public Cursor getPlaylists(int contactId) {
        Cursor cursor = this.context.getContentResolver().query(
                PlaylistContentProvider.PLAYLIST_URI,
                null,
                String.format("%s.[%s]=%s", Contact.TABLE_NAME, Contact.COLUMN__ID, contactId),
                null,
                null);
        return cursor;
    }

    @Override
    public Cursor getMyPlaylists() {
        Cursor cursor = this.context.getContentResolver().query(
                PlaylistContentProvider.PLAYLIST_URI,
                null,
                String.format("arg_contact_id is null"),
                null,
                null);
        return cursor;
    }

    @Override
    public Cursor getSharedPlaylists() {
        Cursor cursor = this.context.getContentResolver().query(
                PlaylistContentProvider.PLAYLIST_URI,
                null,
                String.format("arg_contact_id is not null"),
                null,
                null);
        return cursor;
    }

    @Override
    public Cursor getFavoritesPlaylists() {
        Cursor cursor = this.context.getContentResolver().query(
                PlaylistContentProvider.PLAYLIST_URI,
                null,
                String.format("%s=1", Playlist.COLUMN_FAV),
                null,
                null);
        return cursor;
    }

    @Override
    public Cursor getPlaylistsExcept(int contactId) {
        Cursor cursor = this.context.getContentResolver().query(
                PlaylistContentProvider.PLAYLIST_URI,
                null,
                String.format("%s.[%s]!=%s", Contact.TABLE_NAME, Contact.COLUMN__ID, contactId),
                null,
                null);
        return cursor;
    }

    @Override
    public Cursor getPlaylistSongsView(Playlist playlist) {
        Cursor cursor = this.context.getContentResolver().query(
                PlaylistContentProvider.PLAYLIST_SONGS_URI,
                null,
                String.format("%s=%s", Song.COLUMN_PLAYLIST__ID, playlist.get_id()),
                null,
                null);
        return cursor;
    }


}
