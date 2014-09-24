package jp.enixer.gdskillmanager.database;

public class UserTable {
	private static final String TABLE_NAME = "user_table";
	private static final String COL_ID = "_id";
	private static final String COL_NAME = "name";
	private static final String COL_VERSION = "version";
	private static final String COL_SKILLNOTE_ID = "skillnote_id";
	private static final String COL_SKILLNOTE_NAME = "skillnote_name";
	private static final String COL_SKILL = "skill";
	private static final String CREATE_TABLE_QUERY = "create table "
			+ TABLE_NAME + "(" + COL_ID
			+ " integer primary key autoincrement, " + COL_NAME
			+ " text not null, " + COL_VERSION + " text not null, "
			+ COL_SKILLNOTE_ID + " integer not null, " + COL_SKILLNOTE_NAME
			+ " text, " + COL_SKILL + " real" + ");";

	public static String getTableName() {
		return TABLE_NAME;
	}

	public static String getColId() {
		return COL_ID;
	}

	public static String getColName() {
		return COL_NAME;
	}

	public static String getColVersion() {
		return COL_VERSION;
	}

	public static String getColSkillnoteId() {
		return COL_SKILLNOTE_ID;
	}

	public static String getColSkillnoteName() {
		return COL_SKILLNOTE_NAME;
	}

	public static String getSkill() {
		return COL_SKILL;
	}

	public static String getCreateTableQuery() {
		return CREATE_TABLE_QUERY;
	}
}
