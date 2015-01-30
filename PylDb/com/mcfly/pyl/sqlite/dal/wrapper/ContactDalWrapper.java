package com.mcfly.pyl.sqlite.dal.wrapper;

import android.content.ContentValues;import java.io.Serializable;
import com.mcfly.pyl.sqlite.utils.DateGetter;import com.mcfly.pyl.sqlite.dal.Contact;
import com.mcfly.pyl.sqlite.cursor.ContactCursor;
import java.util.Date;

public class ContactDalWrapper {

    public static Contact getObjectFromDB(ContactCursor cursor, int start) { 
        Contact object_ = new Contact();
        object_.set_id(cursor.getInt(0+start));
        object_.setvalidated(cursor.getInt(1+start) == 0 ? false : true );
        return object_;
    }

    public static int getNbColumns() { 
        return 2;
    }

    public static ContentValues getContentValueFromObject(Serializable object) { 
        Contact object_ = (Contact) object;
        ContentValues values = new ContentValues();
        values.put(Contact.COLUMN__ID,object_.get_id());
        values.put(Contact.COLUMN_VALIDATED,object_.getvalidated());
        return values;
    }

}