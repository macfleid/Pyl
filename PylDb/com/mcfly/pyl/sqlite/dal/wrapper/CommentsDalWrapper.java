package com.mcfly.pyl.sqlite.dal.wrapper;

import android.content.ContentValues;import java.io.Serializable;
import com.mcfly.pyl.sqlite.utils.DateGetter;import com.mcfly.pyl.sqlite.dal.Comments;
import com.mcfly.pyl.sqlite.cursor.CommentsCursor;
import java.util.Date;

public class CommentsDalWrapper {

    public static Comments getObjectFromDB(CommentsCursor cursor, int start) { 
        Comments object_ = new Comments();
        object_.set_id(cursor.getInt(0+start));
        object_.settext(cursor.getString(1+start));
        object_.setPlaylist__id(cursor.getInt(2+start));
        object_.setContact__id(cursor.getInt(3+start));
        return object_;
    }

    public static int getNbColumns() { 
        return 4;
    }

    public static ContentValues getContentValueFromObject(Serializable object) { 
        Comments object_ = (Comments) object;
        ContentValues values = new ContentValues();
        values.put(Comments.COLUMN__ID,object_.get_id());
        values.put(Comments.COLUMN_TEXT,object_.gettext());
        values.put(Comments.COLUMN_PLAYLIST__ID,object_.getPlaylist__id());
        values.put(Comments.COLUMN_CONTACT__ID,object_.getContact__id());
        return values;
    }

}