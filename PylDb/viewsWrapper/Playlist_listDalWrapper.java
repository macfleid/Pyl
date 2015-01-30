package com.kayentis.epro.sqlite.views.wrapper;

import android.database.Cursor;import com.kayentis.epro.sqlite.cursor.*;
import com.kayentis.epro.sqlite.dal.*;import com.kayentis.epro.sqlite.dal.wrapper.*;

public class Playlist_listDalWrapper {
 
   private Playlist playlist;
   private Contact contact;

   public static Playlist getPlaylist(Cursor cursor) {
      int start=0;
      return PlaylistDalWrapper.getObjectFromDB(new PlaylistCursor(cursor), start);
   }
 
   public static Contact getContact(Cursor cursor) {
      int start=0+
      PlaylistDalWrapper.getNbColumns();
      return ContactDalWrapper.getObjectFromDB(new ContactCursor(cursor), start);
   }
 
}
