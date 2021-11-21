package hackerRank.restAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class postTest01 {

	public static void main(String[] args) throws IOException {
		System.out.println(getTotalGoals("Barcelona",2011));
	}

	private static int getTotalGoals(String team, int year) throws IOException {
		final String url = "http://localhost:8080/test/" + year;
		int totalGoalsAtHome = postPageTotalGoals(
				url
				,team
				,0
				,"team1"
				,1);
		int totalGoalsAtVisiting = postPageTotalGoals(
				url
				,team
				,0
				,"team2"
				,1);
		return totalGoalsAtHome + totalGoalsAtVisiting;
	}

	private static int postPageTotalGoals(String request, String team, int sum, String selectTeam, int page) throws IOException {
		URL url = new URL(request);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setConnectTimeout(5000);
		httpURLConnection.setReadTimeout(5000);
		httpURLConnection.addRequestProperty("Content-Type", "application/json; UTF-8");
		httpURLConnection.setDoOutput(true);
		String data = "{ \"selectTeam\" : \""+selectTeam+"\", \"team\" : \""+team+"\" , \"page\" : \" "+page+"\" }";
        byte[] postDataBytes = data.toString().getBytes("UTF-8");


		httpURLConnection.getOutputStream().write(postDataBytes); 

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
		
		return 0;
	}

}
