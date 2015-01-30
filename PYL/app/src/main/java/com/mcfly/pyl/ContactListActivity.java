package com.mcfly.pyl;

import android.app.Activity;
import android.os.Bundle;
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        ContactListBusiness business = new ContactListBusiness(this);

        ListView listView = (ListView) findViewById(R.id.contact_listview);
        listView.setAdapter(ContactListAdapterHelper.getContactListAdapter(this,business.getAvailableContacts()));

        
    }
}
