package com.mcfly.pyl.adapters;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import com.mcfly.pyl.R;

/**
 * Created by mcfly on 29/01/2015.
 */
public class ContactListAdapterHelper {

    public static ListAdapter getContactListAdapter(Context context, Cursor cursor) {
        String[] from = {
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts._ID
        };
        int[] to = {
                R.id.contact_name,
                R.id.contact_account
        };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(context, R.layout.contact_element, cursor, from, to, 0);
        return adapter;
    }

    ////////////////////////////////////////////////////////////////////


}
