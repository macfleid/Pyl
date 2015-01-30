package com.mcfly.pyl.sqlite.dal;
 
import java.io.Serializable;
import java.util.Date;
/*
* AUTO GENERATED FILE 
* creation date : 2015-01-30 11:43 
*/
public class Contact implements Serializable { 

    public static String TABLE_NAME = "Contact"; 
    public final static String COLUMN__ID="_id"; 
    public final static String COLUMN_VALIDATED="validated"; 

    private int _id;
    private boolean validated;

    public int get_id() { 
        return _id;
    }

    public void set_id(int obj) {
        this._id = obj;
    }
    public boolean getvalidated() { 
        return validated;
    }

    public void setvalidated(boolean obj) {
        this.validated = obj;
    }
}
