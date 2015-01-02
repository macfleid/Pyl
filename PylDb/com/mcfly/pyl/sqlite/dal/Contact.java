package com.mcfly.pyl.sqlite.dal;
 
import java.io.Serializable;
import java.util.Date;
/*
* AUTO GENERATED FILE 
* creation date : 2015-01-02 11:43 
*/
public class Contact implements Serializable { 

    public static String TABLE_NAME = "Contact"; 
    public final static String COLUMN__ID="_id"; 

    private int _id;

    public int get_id() { 
        return _id;
    }

    public void set_id(int obj) {
        this._id = obj;
    }
}
