package com.kayentis.epro.sqlite.views.wrapper;

import android.database.Cursor;import com.kayentis.epro.sqlite.cursor.*;
import com.kayentis.epro.sqlite.dal.*;import com.kayentis.epro.sqlite.dal.wrapper.*;

public class Playlist_elementDalWrapper {
 
   private Playlist playlist;
   private Song song;
   private Contact contact;

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
