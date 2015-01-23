package com.mcfly.pyl.adapters;

import android.content.Context;
import android.database.Cursor;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.mcfly.pyl.R;
import com.mcfly.pyl.business.PlaylistBusiness;
import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.transformers.PlaylistTransformer;
import com.mcfly.pyl.view.model.PlaylistUiModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mcfly on 08/01/2015.
 */
public class PlaylistAdapterHelper implements IPlaylistAdapterHelper {

    public PlaylistAdapterHelper(){}

    @Override
    public ListAdapter getPlayListAdapter(Context context) {
        PlaylistBusiness business = new PlaylistBusiness(context);
        Cursor cursor = business.getPlaylist();
        List<PlaylistUiModel> playlistUiModel = PlaylistTransformer.transform(cursor);
        if(cursor!=null) {
            cursor.close();
        }

        String[] from = {
                playlistAdapterKeys.TITLE.name(),
                playlistAdapterKeys.SHAREDBY.name(),
                playlistAdapterKeys.DATE.name(),
                playlistAdapterKeys.AVERAGERATING.name()
        };
        int[] to = {
                R.id.playlist_element_title,
                R.id.playlist_resume,
                R.id.playlist_date,
                R.id.playlist_rating
        };
        SimpleAdapter adapter = new SimpleAdapter(context, adapterTransform(playlistUiModel),
                R.layout.playlist_element,from, to);
        return adapter;
    }

    //-----------------------

    private enum playlistAdapterKeys {
        TITLE,
        SHAREDBY,
        DATE,
        AVERAGERATING;
    }

    private HashMap<String,String> adapterTransform(PlaylistUiModel model) {
        HashMap<String,String> result = new HashMap<String, String>();
        result.put(playlistAdapterKeys.TITLE.name(), model.getTitle());
        result.put(playlistAdapterKeys.SHAREDBY.name(), model.getSharedBy());
        result.put(playlistAdapterKeys.DATE.name(), model.getDate());
        result.put(playlistAdapterKeys.AVERAGERATING.name(), String.valueOf(model.getAverageRating()));
        return result;
    }

    private List<HashMap<String,String>> adapterTransform(List<PlaylistUiModel> model) {
        List<HashMap<String,String>> result = new ArrayList<HashMap<String, String>>();
        for (PlaylistUiModel element : model) {
            result.add(adapterTransform(element));
        }
        return result;
    }

}
