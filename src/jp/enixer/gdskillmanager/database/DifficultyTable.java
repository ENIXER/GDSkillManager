package jp.enixer.gdskillmanager.database;

public class DifficultyTable {
	private static final String TABLE_NAME = "difficulty_table";
	private static final String COL_ID = "_id";
	private static final String COL_NAME = "name";
	private static final String COL_OLD_NAME = "old_name";
	private static final String CREATE_TABLE_QUERY = "create table "
			+ TABLE_NAME + "(" + COL_ID
			+ " integer primary key autoincrement, " + COL_NAME
			+ " text not null, " + COL_OLD_NAME + " text" + ");";
	private static final String[] DIFF_NAMES = { "BASIC", "ADVANCED",
			"EXTREME", "MASTER" };
	private static final String[] DIFF_OLD_NAMES = { "NOVICE", "REGULAR",
			"EXPERT", "MASTER" };

	public static String getTableName() {
		return TABLE_NAME;
	}

	public static String getColId() {
		return COL_ID;
	}

	public static String getColName() {
		return COL_NAME;
	}

	public static String getColOldName() {
		return COL_OLD_NAME;
	}

	public static String getCreateTableQuery() {
		return CREATE_TABLE_QUERY;
	}

	public static String[] getDiffNames() {
		return DIFF_NAMES;
	}

	public static String[] getDiffOldNames() {
		return DIFF_OLD_NAMES;
	}
}
