package com.mcfly.pyl.sqlite.dao.extended.interfaces;

        import android.database.Cursor;

        import com.mcfly.pyl.sqlite.dal.Playlist;

public interface IPlaylist {

    public int save(Playlist element);

    public Cursor getPlaylists();

    public Cursor getPlaylists(int contactId);

    public Cursor getPlaylistsExcept(int contactId);

    public Cursor getPlaylistSongsView(Playlist playlist);

}
