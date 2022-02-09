package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str = reader.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(str);
			String s = tokens.nextToken();
			String t = tokens.nextToken();
			System.out.println(solution(s,t));
		}
	}

	private static String solution(String s, String t) {
		if(s.length() > t.length())
			return "No";
		int index = 0;
		for(int i=0;i<t.length();++i) {
			if(s.charAt(index) == t.charAt(i))
				index++;
			if(index == s.length())
				break;
		}
		return index == s.length() ? "Yes" : "No";
	}

}
