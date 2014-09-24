package jp.enixer.gdskillmanager.views;

import jp.enixer.gdskillmanager.R;
import jp.enixer.gdskillmanager.tasks.GetSkillNoteTask;
import android.app.Activity;
import android.os.Bundle;

public class MenuActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		new GetSkillNoteTask(this).execute(new Integer[] { 1851 });
	}
}
