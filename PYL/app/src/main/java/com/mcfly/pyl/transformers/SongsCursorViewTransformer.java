package com.mcfly.pyl.transformers;

import android.database.Cursor;
import android.util.Log;

import com.mcfly.pyl.sqlite.dal.Song;
import com.mcfly.pyl.sqlite.views.wrapper.Playlist_elementDalWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcfly on 30/01/2015.
 */
public class SongsCursorViewTransformer {

    private final static String TAG = SongsCursorViewTransformer.class.getName();

    public static List<Song> transform(Cursor cursor) {
        Log.d(TAG,"[List<Song> transform(Cursor cursor)]");
        List<Song> result = new ArrayList<Song>();
        if(cursor==null || !cursor.moveToFirst()){
            return result;
        }
        do {
            Song song = Playlist_elementDalWrapper.getSong(cursor);
            Log.d(TAG,"Song:"+song.getartiste()+":"+song.gettitle());
            result.add(song);
        } while (cursor.moveToNext());
        return result;
    }
}
