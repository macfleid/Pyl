package com.mcfly.pyl;

import android.app.ActionBar;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mcfly.pyl.adapters.ContactListAdapterHelper;
import com.mcfly.pyl.business.ContactListBusiness;
import com.mcfly.pyl.business.PlaylistBusiness;
import com.mcfly.pyl.business.exceptions.PlayListCreationException;
import com.mcfly.pyl.view.model.PlaylistCreationModel;


public class CreatePlaylistActivity extends Activity {

    private final static String TAG = CreatePlaylistActivity.class.getName();

    private PlaylistBusiness business;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        business = new PlaylistBusiness(this);
        setContentView(R.layout.activity_create_playlist);
        setTitle(getResources().getString(R.string.create_activity_title));

        Button cancelButton = (Button) findViewById(R.id.create_playlist_cancel);
        Button saveButton = (Button) findViewById(R.id.create_playlist_save);

        setupMenu();
        bindCancelAction(cancelButton);
        bindSaveAction(saveButton);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////

    private void setupMenu() {
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayUseLogoEnabled(false);
    }

    private void bindCancelAction(View view) {
        final Activity activity = this;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(activity);
            }
        });
    }

    private void bindSaveAction(View view) {
        final Activity activity = this;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    business.createPlaylist(getCreationModel());
                } catch (PlayListCreationException e) {
                    Log.e(TAG,"Error while saving new playlist",e);
                    return;
                }
                NavUtils.navigateUpFromSameTask(activity);
            }
        });
    }

    private PlaylistCreationModel getCreationModel() {
        TextView titleTextView = (TextView) findViewById(R.id.create_playlist_title);
        PlaylistCreationModel result = new PlaylistCreationModel(titleTextView.getText().toString());
        return result;
    }

}
