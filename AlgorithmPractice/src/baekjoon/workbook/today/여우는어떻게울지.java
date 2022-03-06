package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 여우는어떻게울지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			Map<String, String> map = new HashMap<>();
			while(true) {
				String str = reader.readLine();
				if(str.equals("what does the fox say?")) {
					break;
				}
				StringTokenizer stringtoken = new StringTokenizer(str);
				String animal = stringtoken.nextToken();
				stringtoken.nextToken();
				String crying = stringtoken.nextToken();
				map.put(crying, animal);
			}
			System.out.println(solution(map, tokens));
		}
	}

	private static String solution(Map<String, String> map, StringTokenizer tokens) {
		StringBuilder sb = new StringBuilder();
		while(tokens.hasMoreTokens()) {
			String str = tokens.nextToken();
			if(!map.containsKey(str)) {
				sb.append(str + " ");
			}
		}
		return sb.toString();
	}

}
