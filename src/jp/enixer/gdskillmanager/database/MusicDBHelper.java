package jp.enixer.gdskillmanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MusicDBHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "gd_skill_data";
	private static final int DATABASE_VERSION = 1;

	public MusicDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(UserTable.getCreateTableQuery());
		db.execSQL(MusicTable.getCreateTableQuery());
		db.execSQL(DifficultyTable.getCreateTableQuery());
		db.execSQL(ChartTable.getCreateTableQuery());
		db.execSQL(ScoreTable.getCreateTableQuery());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
