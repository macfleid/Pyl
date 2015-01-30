package com.mcfly.pyl.transformers;

import android.database.Cursor;

import com.mcfly.pyl.sqlite.dal.Song;
import com.mcfly.pyl.sqlite.views.wrapper.Playlist_elementDalWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcfly on 30/01/2015.
 */
public class SongsCursorViewTransformer {

    public static List<Song> transform(Cursor cursor) {
        List<Song> result = new ArrayList<Song>();
        if(cursor==null || !cursor.moveToFirst()){
            return result;
        }
        do {
            Song song = Playlist_elementDalWrapper.getSong(cursor);
            result.add(song);
        } while (cursor.moveToNext());
        return result;
    }
}
