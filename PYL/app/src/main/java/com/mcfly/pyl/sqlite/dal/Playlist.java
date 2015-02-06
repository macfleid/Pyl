package com.mcfly.pyl.sqlite.dal;
 
import java.io.Serializable;
import java.util.Date;
/*
* AUTO GENERATED FILE 
* creation date : 2015-02-06 14:16 
*/
public class Playlist implements Serializable { 

    public static String TABLE_NAME = "Playlist"; 
    public final static String COLUMN__ID="_id"; 
    public final static String COLUMN_TITLE="title"; 
    public final static String COLUMN_RATE="rate"; 
    public final static String COLUMN_DATE="date"; 
    public final static String COLUMN_FAV="fav"; 
    public final static String COLUMN_CONTACT__ID="Contact__id"; 

    private int _id;
    private String title;
    private int rate;
    private Date date;
    private boolean fav;
    private int Contact__id;

    public int get_id() { 
        return _id;
    }

    public void set_id(int obj) {
        this._id = obj;
    }
    public String gettitle() { 
        return title;
    }

    public void settitle(String obj) {
        this.title = obj;
    }
    public int getrate() { 
        return rate;
    }

    public void setrate(int obj) {
        this.rate = obj;
    }
    public Date getdate() { 
        return date;
    }

    public void setdate(Date obj) {
        this.date = obj;
    }
    public boolean getfav() { 
        return fav;
    }

    public void setfav(boolean obj) {
        this.fav = obj;
    }
    public int getContact__id() { 
        return Contact__id;
    }

    public void setContact__id(int obj) {
        this.Contact__id = obj;
    }
}
