package com.sc.android.meituan.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

	private static final String DB_NAME = "sc.db";
	private static final int DB_VERSION = 1;

	private static DataHelper DB_HELPER = null;

	public static DataHelper getInstanceDatabaseHelper(Context context) {
		if (DB_HELPER == null) {
			DB_HELPER = new DataHelper(context);
		}
		return DB_HELPER;
	}

	public DataHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE student (id	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,	"
				+ "username TEXT NOT NULL,	password TEXT NOT NULL)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
