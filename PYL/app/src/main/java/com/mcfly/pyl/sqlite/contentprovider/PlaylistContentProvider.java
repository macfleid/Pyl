package com.mcfly.pyl.sqlite.contentprovider;
 
 
import com.mcfly.pyl.sqlite.DbManager;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import com.mcfly.pyl.sqlite.dal.Playlist;
import android.content.UriMatcher;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class PlaylistContentProvider extends ContentProvider {
    private DbManager dbManager;
    private static final String BASE_PATH = "Playlist";
    private static final String PLAYLIST_PATH = "PLAYLIST_PATH";
    private static final String PLAYLIST_SONGS_PATH = "PLAYLIST_SONGS_PATH";

    public static final String AUTHORITY = "com.mcfly.pyl.sqlite.contentprovider.PlaylistContentProvider";
    public static final Uri CONTENT_URI = Uri.parse("content://" +AUTHORITY+ "/" + BASE_PATH);
    public static final Uri PLAYLIST_URI = Uri.parse("content://" +AUTHORITY+ "/" + BASE_PATH+ "/" + PLAYLIST_PATH);
    public static final Uri PLAYLIST_SONGS_URI = Uri.parse("content://" +AUTHORITY+ "/" + BASE_PATH+ "/" + PLAYLIST_SONGS_PATH);
    public static final String TYPE = "Playlist";

    private static final int DEFAULT_CODE = 1;
    private static final int PLAYLIST_CODE = 2;
    private static final int PLAYLIST_SONGS_CODE = 3;
    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        static {
            sURIMatcher.addURI(AUTHORITY, BASE_PATH, DEFAULT_CODE);
            sURIMatcher.addURI(AUTHORITY, BASE_PATH + "/" + PLAYLIST_PATH , PLAYLIST_CODE);
            sURIMatcher.addURI(AUTHORITY, BASE_PATH + "/" + PLAYLIST_SONGS_PATH , PLAYLIST_SONGS_CODE);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase database = dbManager.getWritableDatabase();
        int nb = database.delete(Playlist.TABLE_NAME, selection, null);
        if(nb>0) {
            getContext().getContentResolver().notifyChange(uri,null);
        }
        return nb;
    }
 
    @Override
    public String getType(Uri uri) {
        return PlaylistContentProvider.TYPE;
    }
 
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase database = dbManager.getWritableDatabase();
        long id = database.insert(Playlist.TABLE_NAME, null, values);
        if(id>0) {
            getContext().getContentResolver().notifyChange(uri,null);
            return Uri.parse(String.valueOf(id));
        }
        return null;
    }
 
    @Override
    public boolean onCreate() {
        dbManager =  DbManager.getInstance(getContext());
        return false;
    }
 
    @Override 
    public Cursor query(Uri uri, String[] projection, String selection,String[] selectionArgs, String sortOrder) { 
        SQLiteDatabase database =  dbManager.getReadableDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        String groupBy = "";

        int uriType = sURIMatcher.match(uri);
        switch (uriType) {
            case PLAYLIST_CODE:
                queryBuilder.setTables("Playlist_list");
                break;
            case PLAYLIST_SONGS_CODE:
                queryBuilder.setTables("Playlist_element");
                break;
            case DEFAULT_CODE:
                queryBuilder.setTables(Playlist.TABLE_NAME);
                break;
        }
        Cursor cursor = queryBuilder.query(database,null,selection,null,groupBy,null,null);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }
 
    @Override
    public int update(Uri uri, ContentValues values, String selection,String[] selectionArgs) {
        SQLiteDatabase database = dbManager.getWritableDatabase();
        int nbColumn = database.update(Playlist.TABLE_NAME, values, selection, selectionArgs);
        if(nbColumn > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return nbColumn;
    }
}