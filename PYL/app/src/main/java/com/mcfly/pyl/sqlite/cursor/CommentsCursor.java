package com.mcfly.pyl.sqlite.cursor;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.database.CursorWrapper;

public class CommentsCursor extends CursorWrapper {


    public CommentsCursor(Cursor c) {
        super(c);
    }

}