package com.mcfly.pyl.fragments;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.mcfly.pyl.R;
import com.mcfly.pyl.adapters.IPlaylistAdapterHelper;
import com.mcfly.pyl.adapters.PlaylistAdapterHelper;
import com.mcfly.pyl.business.PlaylistBusiness;
import com.mcfly.pyl.menu.MainMenu;


/**
 *
 */
public class PlaylistFragment extends Fragment implements AbsListView.OnItemClickListener {

    private final static String TAG = PlaylistFragment.class.getName();

    public final static String PLAYLIST_LIST_MODE = "PLAYLIST_LIST_MODE";

    private OnFragmentInteractionListener mListener;

    private AbsListView mListView;

    private BaseAdapter mAdapter;

    private IPlaylistAdapterHelper playlistAdapterHelper;

    private MainMenu selectedMode;


    public static PlaylistFragment newInstance(String param1, String param2) {
        PlaylistFragment fragment = new PlaylistFragment();
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PlaylistFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments()==null || !getArguments().containsKey(PLAYLIST_LIST_MODE)) {
            Log.d(TAG, "   [mode default : MainMenu.MINES]");
            this.selectedMode = MainMenu.MINES;
        } else {
            this.selectedMode = (MainMenu) getArguments().getSerializable(PLAYLIST_LIST_MODE);
            Log.d(TAG, "   [mode:]"+selectedMode.name());
        }

        PlaylistBusiness business = new PlaylistBusiness(this.getActivity());
        playlistAdapterHelper = new PlaylistAdapterHelper();

        Cursor cursor = null;

        if(this.selectedMode.equals(MainMenu.FAVORITES)) {
            cursor = business.getPlaylist_favorites();
            Log.d(TAG, "   [cursor:getPlaylist_favorites]");
        } else if (this.selectedMode.equals(MainMenu.MINES)) {
            cursor = business.getPlaylist_mines();
            Log.d(TAG, "   [cursor:getPlaylist_mines]");
        } else if (this.selectedMode.equals(MainMenu.SHARED)) {
            cursor = business.getPlaylist_shared();
            Log.d(TAG, "   [cursor:getPlaylist_shared]");
        }
//        cursor = business.getPlaylist();

        mAdapter = playlistAdapterHelper.getPlayListAdapter(this.getActivity(), cursor);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.playlist, container, false);

        mListView = (AbsListView) view.findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        if (null != mListener) {
//            // Notify the active callbacks interface (the activity, if the
//            // fragment is attached to one) that an item has been selected.
//            mListener.onFragmentInteraction(DummyContent.ITEMS.get(position).id);
//        }
    }


    /**
    * This interface must be implemented by activities that contain this
    * fragment to allow an interaction in this fragment to be communicated
    * to the activity and potentially other fragments contained in that
    * activity.
    * <p>
    * See the Android Training lesson <a href=
    * "http://developer.android.com/training/basics/fragments/communicating.html"
    * >Communicating with Other Fragments</a> for more information.
    */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

//    public enum modes {
//        SHARED_LIBRARY,
//        MINES,
//        FAVORITES
//    }

}
