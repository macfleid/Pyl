package com.mcfly.pyl.sqlite.dao.extended.interfaces;

        import android.database.Cursor;

        import com.mcfly.pyl.sqlite.dal.Playlist;

public interface IPlaylist {

    public int save(Playlist element);

    public Cursor getPlaylists();

    public Cursor getPlaylists(int contactId);

    public Cursor getMyPlaylists();

    public Cursor getSharedPlaylists();

    public Cursor getFavoritesPlaylists();

    public Cursor getPlaylistsExcept(int contactId);

    public Cursor getPlaylistSongsView(Playlist playlist);

}
