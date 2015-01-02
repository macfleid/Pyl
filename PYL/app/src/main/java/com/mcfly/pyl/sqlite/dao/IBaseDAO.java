package com.mcfly.pyl.sqlite.dao;

import java.io.Serializable;

import android.content.ContentValues;
import android.database.Cursor;

public interface IBaseDAO {
	
	public Cursor getFromID(int id,String column);
	
	public Cursor findAll();
	
	public int delete(int[] ids, String column);
	
	public int add(ContentValues values);
	

}
