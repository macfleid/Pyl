package com.mcfly.pyl;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.ListView;

import com.mcfly.pyl.adapters.ContactListAdapterHelper;
import com.mcfly.pyl.business.ContactListBusiness;

/**
 *
 */
public class ContactListActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_contact_list);
        setTitle(getString(R.string.contact_activity_title));

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayUseLogoEnabled(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ContactListBusiness business = new ContactListBusiness(this);

        ListView listView = (ListView) findViewById(R.id.contact_listview);
        listView.setAdapter(ContactListAdapterHelper.getContactListAdapter(this,business.getAvailableContacts()));

        
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
}
