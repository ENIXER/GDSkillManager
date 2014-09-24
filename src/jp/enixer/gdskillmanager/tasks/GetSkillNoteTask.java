package jp.enixer.gdskillmanager.tasks;

import jp.enixer.gdskillmanager.R;
import jp.enixer.gdskillmanager.managers.HTTPManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.TextView;

public class GetSkillNoteTask extends AsyncTask<Integer, Void, Void> {
	private Activity activity;
	private ProgressDialog dialog;
	private HTTPManager httpManager;

	public GetSkillNoteTask(Activity a) {
		activity = a;
		httpManager = new HTTPManager();
	}

	@Override
	protected void onPreExecute() {
		dialog = new ProgressDialog(activity);
		dialog.setMessage("Loading data...");
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.setCancelable(false);
		dialog.show();
	}

	@Override
	protected Void doInBackground(Integer... params) {
		for (int id : params) {
			httpManager.getMusicData(id);
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void v) {
		TextView tv = (TextView) activity.findViewById(R.id.textView1);
		dialog.dismiss();
	}
}
