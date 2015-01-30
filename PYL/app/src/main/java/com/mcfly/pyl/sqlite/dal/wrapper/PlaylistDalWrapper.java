package com.mcfly.pyl.sqlite.dal.wrapper;

import android.content.ContentValues;import java.io.Serializable;
;import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.sqlite.cursor.PlaylistCursor;
import com.mcfly.pyl.utils.DateGetter;

import java.util.Date;

public class PlaylistDalWrapper {

    public static Playlist getObjectFromDB(PlaylistCursor cursor, int start) { 
        Playlist object_ = new Playlist();
        object_.set_id(cursor.getInt(0+start));
        object_.settitle(cursor.getString(1+start));
        object_.setrate(cursor.getInt(2+start));
        Date date = DateGetter.getInstance().getDateFromString(cursor.getString(3+start));
        object_.setdate(date);
        object_.setContact__id(cursor.getInt(4+start));
        return object_;
    }

    public static int getNbColumns() { 
        return 5;
    }

    public static ContentValues getContentValueFromObject(Serializable object) { 
        Playlist object_ = (Playlist) object;
        ContentValues values = new ContentValues();
        values.put(Playlist.COLUMN__ID,object_.get_id());
        values.put(Playlist.COLUMN_TITLE,object_.gettitle());
        values.put(Playlist.COLUMN_RATE,object_.getrate());
        String dateString = DateGetter.getInstance().getStringFromDate(object_.getdate());
        values.put(Playlist.COLUMN_DATE,dateString);
        values.put(Playlist.COLUMN_CONTACT__ID,object_.getContact__id());
        return values;
    }

}