package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 폴리오미노 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		StringBuilder answer = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for(char c : str.toCharArray()) {
			if(c == 'X') {
				sb.append(c);
			}else {
				String now = sb.toString().replaceAll("XXXX", "AAAA").replaceAll("XX", "BB");
				if(sb.length() % 2 != 0) {
					return "-1";
				}
				answer.append(now);
				answer.append(".");
				sb = new StringBuilder();
			}
		}
		if(sb.length() > 0) {
			String now = sb.toString().replaceAll("XXXX", "AAAA").replaceAll("XX", "BB");
			if(sb.length() % 2 != 0) {
				return "-1";
			}
			answer.append(now);
		}
		return answer.toString();
	}

}
