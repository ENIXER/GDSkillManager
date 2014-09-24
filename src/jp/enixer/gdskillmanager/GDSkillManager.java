package jp.enixer.gdskillmanager;

import jp.enixer.gdskillmanager.preferences.Preferences;
import jp.enixer.gdskillmanager.tasks.GetAllMusicTask;
import jp.enixer.gdskillmanager.views.MenuActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GDSkillManager extends Activity {
	Preferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pref = new Preferences(this);
		setContentView(R.layout.activity_gdskill_manager);
		if (pref.isFirstStart()) {
			new GetAllMusicTask(this).execute();
			pref.setFirstStart(false);
		}
	}

	public void onButtonClick(View v) {
		new GetAllMusicTask(this).execute();
//		Intent intent = new Intent(this, MenuActivity.class);
//		startActivity(intent);
	}
}
