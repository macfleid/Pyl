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

    public Cursor getAvailableContacts() {
        Cursor cursor = null;
        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        String[] projection = new String[] {
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME
        };
        String selection = "";
        String order = "";
        String[] selectionArgs = null;
        cursor = context.getContentResolver().query(uri,null,selection,selectionArgs,order);
        return cursor;
    }

    public String getContact(Contact contact) {
        if(contact==null || contact.get_id()==0) {
            return null;
        }
        Cursor cursor = null;
        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        String[] projection = null;
        String selection = String.format("%s=?",ContactsContract.Contacts._ID);
        String order = "";
        String[] selectionArgs = { String.valueOf(contact.get_id()) };
        cursor = context.getContentResolver().query(uri,projection,selection,selectionArgs,order);
        if(cursor==null || !cursor.moveToFirst()) {
            return null;
        }
        String result = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        cursor.close();
        return result;
    }

    public Cursor getAppContacts() {
        return null;
    }
}
