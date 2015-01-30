package com.mcfly.pyl.filldatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.mcfly.pyl.MainActivity;
import com.mcfly.pyl.sqlite.DbManager;

/**
 * Created by mcfly on 28/01/2015.
 */
public class FillDatabase extends ActivityInstrumentationTestCase2<MainActivity> {

    private final static String TAG = FillDatabase.class.getName();

    private MainActivity activity;
    private Context context;
    private SQLiteDatabase database;

    private boolean rollback = false;

    public FillDatabase() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        Log.d(TAG, "... call setUp()");
        context = getInstrumentation().getContext();
//		initDb();
        super.setUp();
        //-- 1 create savePoint
        try {
            database = DbManager.getInstance(context).getWritableDatabase();
        } catch (SQLiteException e) {
            Log.e(TAG, "Error while getting writable database", e);
        }
        if(rollback) {
            database.execSQL("savepoint testpoint");
        }

        //-- 3 get the activity with Intent
        this.activity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        Log.d(TAG, "... call tearDown()");
        super.tearDown();
        try {
            database = DbManager.getInstance(activity).getWritableDatabase();
        } catch (SQLiteException e) {
            Log.e(TAG, "Error while getting writable database", e);
        }
        //-- restore savePoint
        if(rollback) {
            database.execSQL(";rollback to testpoint");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void testFillDatabase() {
        Log.d(TAG, String.format("[fillDatabase][rollback %s]", String.valueOf(rollback)));
        DbManager.getInstance(context).executeTestFile();
    }

}