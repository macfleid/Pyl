package com.mcfly.pyl.sqlite.dao.extended;

import android.content.Context;

import com.mcfly.pyl.sqlite.contentprovider.PlaylistContentProvider;
import com.mcfly.pyl.sqlite.dal.wrapper.ContactDalWrapper;

import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.mcfly.pyl.sqlite.contentprovider.ContactContentProvider;
import com.mcfly.pyl.sqlite.dao.BaseDAO;
import com.mcfly.pyl.sqlite.dal.Contact;
import com.mcfly.pyl.sqlite.dao.extended.interfaces.IContact;

public class ContactDAO extends BaseDAO implements IContact {

    private final static String TAG = ContactDAO.class.getName();

    public ContactDAO(Context c) {
        super(c, ContactContentProvider.CONTENT_URI);
        Log.d(TAG, "#ContactDAO");    }

    @Override
    public int save(Contact element) {
       int result = add(ContactDalWrapper.getContentValueFromObject(element));
       return result;
    }

    @Override
    public Cursor getContacts() {
        Cursor cursor = this.context.getContentResolver().query(
                this.contentProviderUri,
                null,
                String.format("%s.[%s]=1", Contact.TABLE_NAME, Contact.COLUMN_VALIDATED ),
                null,
                null);
        return cursor;
    }

    @Override
    public Cursor getContactsRequests() {
        Cursor cursor = this.context.getContentResolver().query(
                this.contentProviderUri,
                null,
                String.format("%s.[%s]=0", Contact.TABLE_NAME, Contact.COLUMN_VALIDATED ),
                null,
                null);
        return cursor;
    }

    @Override
    public int getRequestCount() {
        Cursor cursor = this.context.getContentResolver().query(
                this.contentProviderUri,
                null,
                String.format("%s.[%s]=0", Contact.TABLE_NAME, Contact.COLUMN_VALIDATED ),
                null,
                null);
        int result = 0;
        if(cursor!=null) {
            result = cursor.getCount();
            cursor.close();
        }
        return result;
    }
}
