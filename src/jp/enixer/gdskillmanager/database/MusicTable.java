package jp.enixer.gdskillmanager.database;

public class MusicTable {
	private static final String TABLE_NAME = "music_table";
	private static final String COL_ID = "_id";
	private static final String COL_NAME = "name";
	private static final String CREATE_TABLE_QUERY = "create table "
			+ TABLE_NAME + "(" + COL_ID
			+ " integer primary key autoincrement, " + COL_NAME
			+ " text not null" + ");";

	public static String getTableName() {
		return TABLE_NAME;
	}

	public static String getColId() {
		return COL_ID;
	}

	public static String getColName() {
		return COL_NAME;
	}

	public static String getCreateTableQuery() {
		return CREATE_TABLE_QUERY;
	}
}
