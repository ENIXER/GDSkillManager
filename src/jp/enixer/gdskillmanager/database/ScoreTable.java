package jp.enixer.gdskillmanager.database;

public class ScoreTable {
	private static final String TABLE_NAME = "score_table";
	private static final String COL_ID = "_id";
	private static final String COL_USER_ID = "name";
	private static final String COL_CHART_ID = "old_name";
	private static final String COL_ACHIEVEMENT_RATE = "level";
	private static final String COL_COMMENT = "comment";
	private static final String CREATE_TABLE_QUERY = "create table "
			+ TABLE_NAME + "(" + COL_ID
			+ " integer primary key autoincrement, " + COL_USER_ID
			+ " integer not null, " + COL_CHART_ID + " integer not null, "
			+ COL_ACHIEVEMENT_RATE + " real not null, " + COL_COMMENT + " text"
			+ ");";

	public static String getTableName() {
		return TABLE_NAME;
	}

	public static String getColId() {
		return COL_ID;
	}

	public static String getColUserId() {
		return COL_USER_ID;
	}

	public static String getColChartId() {
		return COL_CHART_ID;
	}

	public static String getColAchievementRate() {
		return COL_ACHIEVEMENT_RATE;
	}

	public static String getColComment() {
		return COL_COMMENT;
	}

	public static String getCreateTableQuery() {
		return CREATE_TABLE_QUERY;
	}

}
