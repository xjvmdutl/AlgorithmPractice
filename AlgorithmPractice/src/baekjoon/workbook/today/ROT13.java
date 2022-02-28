package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(reader.readLine()));
	}

	private static String solution(String str) {
		StringBuilder sb = new StringBuilder();
		char[] upper = new char['Z'-'A'+1];
		char[] lower = new char['z'-'a'+1];
		for(int i='A';i<='Z';++i) {
			char c = (char)i;
			upper[i-'A'] = c;
			lower[i-'A'] = Character.toLowerCase(c);
		}
		for(char c : str.toCharArray()) {
			if(Character.isAlphabetic(c)) {
				if(Character.isUpperCase(c)) {
					int index = (c - 'A' + 13)%upper.length;
					sb.append(upper[index]);
				}else {
					int index = (c - 'a' + 13)%upper.length;
					sb.append(lower[index]);
				}
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
