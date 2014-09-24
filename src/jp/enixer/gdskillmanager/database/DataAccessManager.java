package jp.enixer.gdskillmanager.database;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class DataAccessManager {
	private SQLiteDatabase db;
	private MusicDBHelper helper;

	public DataAccessManager(Context context) {
		helper = new MusicDBHelper(context);
	}

	public void createDifficultyTable() {
		if (db == null || !db.isOpen()) {
			db = helper.getWritableDatabase();
		}
		if (DatabaseUtils.queryNumEntries(db, DifficultyTable.getTableName()) > 0) {
			return;
		}
		String[] difName = DifficultyTable.getDiffNames();
		String[] difOldName = DifficultyTable.getDiffOldNames();
		ContentValues values = new ContentValues();
		for (int i = 0; i < difName.length; i++) {
			values.clear();
			values.put(DifficultyTable.getColName(), difName[i]);
			values.put(DifficultyTable.getColOldName(), difOldName[i]);
			db.insert(DifficultyTable.getTableName(), null, values);
		}
		db.close();
	}

	public boolean refreshAllMusicData(Elements tables) {
		clearTable(MusicTable.getTableName());
		if (db == null || !db.isOpen()) {
			db = helper.getWritableDatabase();
		}
		db.beginTransaction();
		SQLiteStatement musicStatement = db.compileStatement("insert into "
				+ MusicTable.getTableName() + "(" + MusicTable.getColName()
				+ ")" + " values (?);");
		for (Element table : tables) {
			Elements rows = table.getElementsByTag("tr");
			for (Element row : rows) {
				Elements elem = row.getElementsByTag("td");
				if (elem.size() != 15) {
					continue;
				}
				musicStatement.bindString(1, elem.get(0).text());
				musicStatement.executeInsert();
			}
		}
		db.setTransactionSuccessful();
		db.endTransaction();
		db.close();
		return true;
	}

	public List<String> getAllMusicName() {
		if (db == null || !db.isOpen()) {
			db = helper.getReadableDatabase();
		}
		List<String> result = new ArrayList<String>();
		Cursor cursor = db.query(MusicTable.getTableName(),
				new String[] { MusicTable.getColName() }, null, null, null,
				null, null);
		while (cursor.moveToNext()) {
			result.add(cursor.getString(0));
		}
		cursor.close();
		return result;
	}

	public void clearTable(String tableName) {
		if (db == null || !db.isOpen()) {
			db = helper.getWritableDatabase();
		}
		db.delete(tableName, null, null);
		db.close();
	}
}
