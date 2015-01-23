package com.mcfly.pyl.business;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.mcfly.pyl.sqlite.dal.Contact;

/**
 * Created by mcfly on 23/01/2015.
 */
public class ContactListBusiness {

    private final Context context;

    private boolean mShowInvisible=true;

    public ContactListBusiness(Context context) {
        this.context = context;
    }

    public Cursor getContacts() {
        Cursor cursor = null;
        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        String[] projection = new String[] {
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME
        };
        String selection = "";
        String order = "";
        String[] selectionArgs = null;
        cursor = context.getContentResolver().query(uri,projection,selection,selectionArgs,order);
        return cursor;
    }
}
