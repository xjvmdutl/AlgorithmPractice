package hackerRank.restAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class getTest02 {

	public static void main(String[] args) throws IOException {
		System.out.println(getNumDraws(2011));
	}

	private static int getNumDraws(int year) throws IOException {
		final String url = "https://jsonmock.hackerrank.com/api/football_matches?year="+year;
		final int maxScore = 10;
		int totalNumDraws = 0;
		for(int score =0;score <= 10;++score) {
			totalNumDraws += getTotalNumDraws(String.format(url + "&team1goals=%d&team2goals=%d", score,score));
		}
		return totalNumDraws;
	}
	private static int getTotalNumDraws(String request) throws IOException {
		URL url = new URL(request);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setConnectTimeout(5000);
		httpURLConnection.setReadTimeout(5000);
		httpURLConnection.addRequestProperty("Content-Type", "application/json");
		
		int status = httpURLConnection.getResponseCode();
		
		InputStream in = (status < 200 || status > 299) ? 
				httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String responseLine;
		StringBuffer responseContent = new StringBuffer();
		while((responseLine = br.readLine()) != null) {
			responseContent.append(responseLine);
		}
		br.close();
		httpURLConnection.disconnect();
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByExtension("js");
		
		String script = "var obj = JSON.parse('" + responseContent.toString() + "');";
		script += "var total = obj.total;";
		
		try {
			engine.eval(script);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
		if(engine.get("total") == null)
			throw new RuntimeException("Cannot retrieve data from the server");
		
		return (int)engine.get("total");
	}

}
