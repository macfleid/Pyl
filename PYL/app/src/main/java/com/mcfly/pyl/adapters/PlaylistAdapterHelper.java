package com.mcfly.pyl.adapters;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.mcfly.pyl.IPlaylistActions;
import com.mcfly.pyl.R;
import com.mcfly.pyl.business.PlaylistBusiness;
import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.sqlite.dao.extended.interfaces.IPlaylist;
import com.mcfly.pyl.transformers.PlaylistTransformer;
import com.mcfly.pyl.view.model.PlaylistUiModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mcfly on 08/01/2015.
 */
public class PlaylistAdapterHelper implements IPlaylistAdapterHelper {

    private final static String TAG = PlaylistAdapterHelper.class.getName();


    public PlaylistAdapterHelper(){}


    @Override
    public BaseAdapter getPlayListAdapter(Context context, Cursor cursor) {
        Log.d(TAG, "[getPlayListAdapter]");
        List<PlaylistUiModel> playlistUiModel = PlaylistTransformer.transform(context,cursor);
        List<Playlist> playlistLists = PlaylistTransformer.transformToDbModel(cursor);
        playListAdapter result = new playListAdapter(context);
        result.setPlaylistUiModels(playlistUiModel);
        result.setPlaylists(playlistLists);
        if(cursor!=null) {
            cursor.close();
        }
        return result;

    }

    //-----------------------

    private class playListAdapter extends ArrayAdapter<PlaylistUiModel> {

        private Context context;

        private List<PlaylistUiModel> playlistUiModels;

        private List<Playlist> playlists;

        private IPlaylistActions listener;


        private playListAdapter(Context context) {
            super(context, R.layout.playlist_element);
            this.listener = (IPlaylistActions) context;
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.playlist_element, parent, false);
            setLayout(view, getItem(position), playlists.get(position));
            return view;
        }

        @Override
        public PlaylistUiModel getItem(int position) {
            return playlistUiModels.get(position);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        public void setPlaylistUiModels(List<PlaylistUiModel> playlistUiModels) {
            this.playlistUiModels = playlistUiModels;
        }

        public void setPlaylists(List<Playlist> playlists) {
            this.playlists = playlists;
        }

        @Override
        public int getCount() {
            return this.playlistUiModels.size();
        }

        /**
         *
         * @param view
         * @param model
         */
        private void setLayout(View view, PlaylistUiModel model, final Playlist playlist) {
            ImageView image = (ImageView) view.findViewById(R.id.playlist_element_image);
            TextView title = (TextView) view.findViewById(R.id.playlist_element_title);
            RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            TextView textResume = (TextView) view.findViewById(R.id.playlist_resume);
            TextView textDate = (TextView) view.findViewById(R.id.playlist_date);

            title.setText(model.getTitle());
            ratingBar.setRating(model.getAverageRating());
            String stringTextResume = model.getSharedBy()!=null ?
                    String.format( context.getString(R.string.playlist_sharedby_label),model.getSharedBy()) : null;
            textResume.setText(stringTextResume);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.showPlaylist(playlist);
                }
            });
        }

    }


}
