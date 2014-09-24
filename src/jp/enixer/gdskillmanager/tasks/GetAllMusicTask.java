package jp.enixer.gdskillmanager.tasks;

import org.jsoup.select.Elements;

import jp.enixer.gdskillmanager.R;
import jp.enixer.gdskillmanager.database.DataAccessManager;
import jp.enixer.gdskillmanager.managers.HTTPManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GetAllMusicTask extends AsyncTask<Void, Integer, Boolean> {
	private HTTPManager httpManager;
	private DataAccessManager dataAccessManager;
	private ProgressDialog dialog;
	private Activity activity;

	public GetAllMusicTask(Activity a) {
		activity = a;
		httpManager = new HTTPManager();
		dataAccessManager = new DataAccessManager(activity);
	}

	@Override
	protected void onPreExecute() {
		dialog = new ProgressDialog(activity);
		dialog.setMessage("楽曲データ取得中...");
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.setCancelable(false);
		dialog.show();
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		dataAccessManager.createDifficultyTable();
		Elements tables = httpManager.getAllMusicData();
		if (tables == null) {
			return false;
		}
		return dataAccessManager.refreshAllMusicData(tables);
	}

	@Override
	protected void onPostExecute(Boolean result) {
		if (!result) {
			dialog.dismiss();
			AlertDialog.Builder builder = new AlertDialog.Builder(activity);
			builder.setTitle("Error").setMessage("楽曲データが正常に取得できませんでした")
					.setPositiveButton("OK", null).show();
			return;
		}
		ListView lv = (ListView) activity.findViewById(R.id.sample_list);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
				android.R.layout.simple_list_item_1,
				dataAccessManager.getAllMusicName());
		lv.setAdapter(adapter);
		dialog.dismiss();
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
		builder.setTitle("Success").setMessage("楽曲データを正常に取得しました")
		.setPositiveButton("OK", null).show();
	}
}
