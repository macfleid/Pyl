package com.mcfly.pyl.sqlite.dao;

import java.io.Serializable;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public abstract class BaseDAO implements IBaseDAO {
	private final static String TAG = BaseDAO.class.getName();
	
	protected Context context;
	protected Uri contentProviderUri;

	public BaseDAO(Context c, Uri contentProviderUri) {
		this.context = c;
		this.contentProviderUri = contentProviderUri;
	}

	@Override
	public Cursor getFromID(int id, String column) {
		Log.d(TAG, "... call getFromID:"+id);
		Cursor cursor = context.getContentResolver().query(contentProviderUri,
                null, column+"="+id,null,null);
        return cursor;
	}

	@Override
	public Cursor findAll() {
        Log.d(TAG, "... call findAll");
		Cursor cursor = context.getContentResolver().query(contentProviderUri,
                null, null,null,null);
		return cursor;
	}

	@Override
	public int delete(int[] ids, String column) {
		Log.d(TAG, "... call delete: On column "+column);
		String where = column+" IN (";
		for (int id : ids ) {
			where+= id;
			Log.d(TAG, "#"+id);
			if (ids[ids.length-1]!=id) {
				where+= ",";
			}
		}
		where += ")";
		int result = context.getContentResolver().delete(contentProviderUri, where, null);
		Log.d(TAG, "   deleted "+result+" elements");
		return result;
	}

	@Override
	public int add(ContentValues values) {
		Log.d(TAG, "... call add with "+values.size()+" values");
		Uri uri = context.getContentResolver().insert(contentProviderUri, values);
		if(uri!=null) {
			String id = uri.toString();
			Log.d(TAG, "   added element with id :"+id);
			return Integer.valueOf(id);
		}
		Log.w(TAG, "   can't add with "+values.size()+" values");
		return -1;
	}
	
}
