package jp.enixer.gdskillmanager.database;

public class ChartTable {
	private static final String TABLE_NAME = "chart_table";
	private static final String COL_ID = "_id";
	private static final String COL_MUSIC_ID = "name";
	private static final String COL_DIFFICULTY_ID = "old_name";
	private static final String COL_LEVEL = "level";
	private static final String CREATE_TABLE_QUERY = "create table "
			+ TABLE_NAME + "(" + COL_ID
			+ " integer primary key autoincrement, " + COL_MUSIC_ID
			+ " integer not null, " + COL_DIFFICULTY_ID + " integer not null, "
			+ COL_LEVEL + " real not null" + ");";

	public static String getTableName() {
		return TABLE_NAME;
	}

	public static String getColId() {
		return COL_ID;
	}

	public static String getColMusicId() {
		return COL_MUSIC_ID;
	}

	public static String getColDifficultyId() {
		return COL_DIFFICULTY_ID;
	}

	public static String getColLevel() {
		return COL_LEVEL;
	}

	public static String getCreateTableQuery() {
		return CREATE_TABLE_QUERY;
	}
}
