package com.mcfly.pyl.sqlite.cursor;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.database.CursorWrapper;

public class SongCursor extends CursorWrapper {


    public SongCursor(Cursor c) {
        super(c);
    }

}