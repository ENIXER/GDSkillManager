package jp.enixer.gdskillmanager.managers;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HTTPManager {
	private static final String URL_BASE = "http://xv-s.heteml.jp/skill/";
	private static final String URL_MUSIC = "music_";
	private static final String URL_GDOD = "gdod.php?";
	private static final String URL_UID = "uid=";
	private static final String URL_KEY = "k=";
	private StringBuilder urlBuilder;
	private Document document;

	public void getMusicData(int id) {
		urlBuilder = new StringBuilder(URL_BASE).append(URL_GDOD).append(
				URL_UID);
		try {
			document = Jsoup.connect(
					urlBuilder.append('g').append(id).toString()).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO: データベースに情報を保存する
	}

	public Elements getAllMusicData() {
		urlBuilder = new StringBuilder(URL_BASE).append(URL_MUSIC)
				.append(URL_GDOD).append(URL_KEY);
		try {
			Elements elements = new Elements();
			document = Jsoup.connect(urlBuilder.append("new").toString()).get();
			Elements tables = document.getElementsByTag("table");
			elements.add(tables.get(1));
			document = Jsoup.connect(urlBuilder.append("old").toString()).get();
			tables = document.getElementsByTag("table");
			elements.add(tables.get(1));
			return elements;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
