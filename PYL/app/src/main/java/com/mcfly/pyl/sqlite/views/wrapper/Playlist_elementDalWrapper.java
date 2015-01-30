package com.mcfly.pyl.sqlite.views.wrapper;

import android.database.Cursor;
import com.mcfly.pyl.sqlite.cursor.ContactCursor;
import com.mcfly.pyl.sqlite.cursor.PlaylistCursor;
import com.mcfly.pyl.sqlite.cursor.SongCursor;
import com.mcfly.pyl.sqlite.dal.Contact;
import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.sqlite.dal.Song;
import com.mcfly.pyl.sqlite.dal.wrapper.ContactDalWrapper;
import com.mcfly.pyl.sqlite.dal.wrapper.PlaylistDalWrapper;
import com.mcfly.pyl.sqlite.dal.wrapper.SongDalWrapper;

public class Playlist_elementDalWrapper {
 
   public static Playlist getPlaylist(Cursor cursor) {
      int start=0;
      return PlaylistDalWrapper.getObjectFromDB(new PlaylistCursor(cursor), start);
   }
 
   public static Song getSong(Cursor cursor) {
      int start=0+
      PlaylistDalWrapper.getNbColumns();
      return SongDalWrapper.getObjectFromDB(new SongCursor(cursor), start);
   }
 
   public static Contact getContact(Cursor cursor) {
      int start=0+
      PlaylistDalWrapper.getNbColumns()+
      SongDalWrapper.getNbColumns();
      return ContactDalWrapper.getObjectFromDB(new ContactCursor(cursor), start);
   }
 
}
