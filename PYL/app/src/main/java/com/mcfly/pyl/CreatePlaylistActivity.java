package com.mcfly.pyl;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mcfly.pyl.adapters.ContactListAdapterHelper;
import com.mcfly.pyl.business.ContactListBusiness;


public class CreatePlaylistActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_playlist);
        setTitle(getString(R.string.create_activity_title));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
