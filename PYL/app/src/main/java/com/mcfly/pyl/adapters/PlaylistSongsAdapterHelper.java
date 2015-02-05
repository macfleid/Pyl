package com.mcfly.pyl.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mcfly.pyl.IPlaylistActions;
import com.mcfly.pyl.R;
import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.sqlite.dal.Song;
import com.mcfly.pyl.view.model.PlaylistUiModel;

import java.util.List;

/**
 * Created by mcfly on 30/01/2015.
 */
public class PlaylistSongsAdapterHelper {

    public BaseAdapter getPlayListSongsAdapter(Context context, List<Song> songList) {
        playListSongsAdapter adapter = new playListSongsAdapter(context, songList);
        return adapter;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // PLAYLIST_SONGS_ADAPTER
    ////////////////////////////////////////////////////////////////////////////////////////

    private class playListSongsAdapter extends ArrayAdapter<Song> {

        private List<Song> songList;
        private IPlaylistActions listener;

        public playListSongsAdapter(Context context, List<Song> songList) {
            super(context, R.layout.playlist_song_element);
            this.songList = songList;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.playlist_song_element, parent, false);
            setLayout(view, getItem(position));
            return view;
        }

        @Override
        public Song getItem(int position) {
            return songList.get(position);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public int getCount() {
            return this.songList.size();
        }

        /**
         *
         * @param view
         * @param song
         */
        private void setLayout(View view, final Song song) {
            TextView title = (TextView) view.findViewById(R.id.song_title);
            TextView artist = (TextView) view.findViewById(R.id.song_artist);

            title.setText(song.gettitle());
            artist.setText(song.getartiste());
        }
    }

}
