package com.mcfly.pyl.transformers;

import android.database.Cursor;

import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.sqlite.views.wrapper.Playlist_listDalWrapper;
import com.mcfly.pyl.utils.DateGetter;
import com.mcfly.pyl.view.model.PlaylistUiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcfly on 08/01/2015.
 */
public class PlaylistTransformer {

    public static List<PlaylistUiModel> transform(Cursor cursor) {
        List<PlaylistUiModel> result = new ArrayList<PlaylistUiModel>();
        if(cursor==null || !cursor.moveToFirst()) {
            return result;
        }
        do {
            Playlist playlist = Playlist_listDalWrapper.getPlaylist(cursor);
            result.add(toPlaylistUiModel(playlist));
        } while(cursor.moveToNext());
        cursor.close();
        return result;
    }

    //////////////////////////////////////

    /**
     * TODO : sharedBy / averageRating / nbSongs
     * @param playlist
     * @return
     */
    private static PlaylistUiModel toPlaylistUiModel(Playlist playlist) {
        PlaylistUiModel result = new PlaylistUiModel(
                playlist.gettitle(),
                "sharedBy[TODO]",
                DateGetter.getStringFromDate(playlist.getdate()),
                5,2
        );
        return result;
    }
}
