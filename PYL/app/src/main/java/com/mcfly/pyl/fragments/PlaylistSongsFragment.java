package com.mcfly.pyl.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mcfly.pyl.IPlaylistActions;
import com.mcfly.pyl.R;
import com.mcfly.pyl.adapters.PlaylistSongsAdapterHelper;
import com.mcfly.pyl.business.PlaylistBusiness;
import com.mcfly.pyl.sqlite.dal.Playlist;
import com.mcfly.pyl.transformers.SongsCursorViewTransformer;

/**
 * Created by mcfly on 30/01/2015.
 */
public class PlaylistSongsFragment extends Fragment {

    private final static String TAG = PlaylistSongsFragment.class.getName();

    public final static String KEY_PLAYLIST_OBJECT = "KEY_PLAYLIST_OBJECT";
    public final static String KEY_EDIT_MODE = "KEY_EDIT_MODE";

    private IPlaylistActions listener;
    private PlaylistBusiness business;
    private Playlist playlist;
    private Cursor cursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        business = new PlaylistBusiness(getActivity());

        if(getArguments()!=null && getArguments().containsKey(KEY_PLAYLIST_OBJECT)) {
            Playlist playlist = (Playlist) getArguments().getSerializable(KEY_PLAYLIST_OBJECT);
            cursor = business.getPlaylistSongs(playlist);
            this.playlist = playlist;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.playlist_songs, container, false);
        if(cursor==null) {
            Log.d(TAG, "No songs in this playlist found");
            return view;
        }
        PlaylistSongsAdapterHelper helper = new PlaylistSongsAdapterHelper();
        BaseAdapter adapter = helper.getPlayListSongsAdapter(getActivity(), SongsCursorViewTransformer.transform(cursor));

        ListView listView = (ListView) view.findViewById(R.id.songs_listview);
        TextView title = (TextView) view.findViewById(R.id.playlist_title);
        TextView backButton = (TextView) view.findViewById(R.id.back_buttton);

        listView.setAdapter(adapter);
        title.setText(playlist.gettitle());
        bindBackAction(backButton);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (IPlaylistActions) activity;
    }



    ///////////////////////////////////////////////////////////////////

    private void bindBackAction(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.back();
            }
        });
    }
}
