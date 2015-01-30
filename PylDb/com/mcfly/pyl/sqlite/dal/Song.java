package com.mcfly.pyl.sqlite.dal;
 
import java.io.Serializable;
import java.util.Date;
/*
* AUTO GENERATED FILE 
* creation date : 2015-01-30 11:43 
*/
public class Song implements Serializable { 

    public static String TABLE_NAME = "Song"; 
    public final static String COLUMN__ID="_id"; 
    public final static String COLUMN_LINK="link"; 
    public final static String COLUMN_ARTISTE="artiste"; 
    public final static String COLUMN_TITLE="title"; 
    public final static String COLUMN_DATE="date"; 
    public final static String COLUMN_PLAYLIST__ID="Playlist__id"; 

    private int _id;
    private String link;
    private String artiste;
    private String title;
    private Date date;
    private int Playlist__id;

    public int get_id() { 
        return _id;
    }

    public void set_id(int obj) {
        this._id = obj;
    }
    public String getlink() { 
        return link;
    }

    public void setlink(String obj) {
        this.link = obj;
    }
    public String getartiste() { 
        return artiste;
    }

    public void setartiste(String obj) {
        this.artiste = obj;
    }
    public String gettitle() { 
        return title;
    }

    public void settitle(String obj) {
        this.title = obj;
    }
    public Date getdate() { 
        return date;
    }

    public void setdate(Date obj) {
        this.date = obj;
    }
    public int getPlaylist__id() { 
        return Playlist__id;
    }

    public void setPlaylist__id(int obj) {
        this.Playlist__id = obj;
    }
}
