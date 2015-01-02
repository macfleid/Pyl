package com.mcfly.pyl.sqlite.dal;
 
import java.io.Serializable;
import java.util.Date;
/*
* AUTO GENERATED FILE 
* creation date : 2015-01-02 11:43 
*/
public class Playlist implements Serializable { 

    public static String TABLE_NAME = "Playlist"; 
    public final static String COLUMN__ID="_id"; 
    public final static String COLUMN_TITLE="title"; 
    public final static String COLUMN_RATE="rate"; 
    public final static String COLUMN_DATE="date"; 

    private int _id;
    private String title;
    private int rate;
    private Date date;

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
}