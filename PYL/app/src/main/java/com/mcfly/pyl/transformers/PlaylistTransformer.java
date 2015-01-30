package com.mcfly.pyl.transformers;

import android.database.Cursor;
import android.util.Log;

import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.sqlite.views.wrapper.Playlist_listDalWrapper;
import com.mcfly.pyl.utils.DateGetter;
import com.mcfly.pyl.view.model.PlaylistUiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcfly on 08/01/2015.
 */
public class PlaylistTransformer {

    private final static String TAG = PlaylistTransformer.class.getName();

    public static List<PlaylistUiModel> transform(Cursor cursor) {
        List<PlaylistUiModel> result = new ArrayList<PlaylistUiModel>();
        if(cursor==null || !cursor.moveToFirst()) {
            return result;
        }
        do {
            Playlist playlist = Playlist_listDalWrapper.getPlaylist(cursor);
            result.add(toPlaylistUiModel(playlist));
        } while(cursor.moveToNext());
        Log.d(TAG, "::"+cursor.getCount());
        return result;
    }


    public static List<Playlist> transformToDbModel(Cursor cursor) {
        ArrayList<Playlist> result = new ArrayList<Playlist>();
        if(cursor==null || !cursor.moveToFirst()) {
            return result;
        }
        do {
            Playlist playlist = Playlist_listDalWrapper.getPlaylist(cursor);
            result.add(playlist);
        } while(cursor.moveToNext());
        Log.d(TAG, "::"+cursor.getCount());
        return result;
    }

    //////////////////////////////////////

    /**
     * TODO : sharedBy /  nbSongs
     * @param playlist
     * @return
     */
    private static PlaylistUiModel toPlaylistUiModel(Playlist playlist) {
        PlaylistUiModel result = new PlaylistUiModel(
                playlist.gettitle(),
                "sharedBy[TODO]",
                DateGetter.getStringFromDate(playlist.getdate()),
                playlist.getrate(),2
        );
        return result;
    }
}
