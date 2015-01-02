package com.mcfly.pyl.sqlite.cursor;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.database.CursorWrapper;

public class PlaylistCursor extends CursorWrapper {


    public PlaylistCursor(Cursor c) {
        super(c);
    }

}