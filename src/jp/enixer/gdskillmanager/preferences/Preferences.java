package jp.enixer.gdskillmanager.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class Preferences {
	private SharedPreferences sp;

	private static final String FIRST_START = "first_start";

	public Preferences(Context context) {
		sp = PreferenceManager.getDefaultSharedPreferences(context);
	}

	public boolean isFirstStart() {
		return sp.getBoolean(FIRST_START, true);
	}

	public void setFirstStart(boolean flg) {
		Editor editor = sp.edit();
		editor.putBoolean(FIRST_START, flg);
		editor.commit();
	}
}
