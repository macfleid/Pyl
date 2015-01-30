package com.mcfly.pyl.sqlite.dao.extended.interfaces;

import android.database.Cursor;

import com.mcfly.pyl.sqlite.dal.Contact;

public interface IContact{

    public int save(Contact element);

    public Cursor getContacts();

    public Cursor getContactsRequests();

    public int getRequestCount();

}
