package com.mcfly.pyl.sqlite.cursor;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.database.CursorWrapper;

public class ContactCursor extends CursorWrapper {


    public ContactCursor(Cursor c) {
        super(c);
    }

}