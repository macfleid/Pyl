package com.mcfly.pyl.sqlite.dao.extended;

import android.content.Context;
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
}
