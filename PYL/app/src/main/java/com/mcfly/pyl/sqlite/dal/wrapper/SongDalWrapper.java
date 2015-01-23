package com.mcfly.pyl.sqlite.dal.wrapper;

import android.content.ContentValues;import java.io.Serializable;
import com.mcfly.pyl.sqlite.dal.Song;
import com.mcfly.pyl.sqlite.cursor.SongCursor;
import com.mcfly.pyl.utils.DateGetter;

import java.util.Date;

public class SongDalWrapper {

    public static Song getObjectFromDB(SongCursor cursor, int start) { 
        Song object_ = new Song();
        object_.set_id(cursor.getInt(0+start));
        object_.setlink(cursor.getString(1+start));
        object_.setartiste(cursor.getString(2+start));
        object_.settitle(cursor.getString(3+start));
        Date date = DateGetter.getInstance().getDateFromString(cursor.getString(4+start));
        object_.setdate(date);
        object_.setPlaylist__id(cursor.getInt(5+start));
        return object_;
    }

    public static int getNbColumns() { 
        return 6;
    }

    public static ContentValues getContentValueFromObject(Serializable object) { 
        Song object_ = (Song) object;
        ContentValues values = new ContentValues();
        values.put(Song.COLUMN__ID,object_.get_id());
        values.put(Song.COLUMN_LINK,object_.getlink());
        values.put(Song.COLUMN_ARTISTE,object_.getartiste());
        values.put(Song.COLUMN_TITLE,object_.gettitle());
        String dateString = DateGetter.getInstance().getStringFromDate(object_.getdate());
        values.put(Song.COLUMN_DATE,dateString);
        values.put(Song.COLUMN_PLAYLIST__ID,object_.getPlaylist__id());
        return values;
    }

}