package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한국이그리울땐서버에접속하지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String pattern = reader.readLine();
		int index = pattern.indexOf("*");
		String str1 = pattern.substring(0, index);
		String str2 = pattern.substring(index+1);
		for(int i=0;i<n;++i) {
			System.out.println(solution(str1, str2, reader.readLine()));
		}
		reader.close();
	}

	private static String solution(String pattern1, String pattern2, String str) {
		String answer = "NE";
		
		if(str.startsWith(pattern1)) {
			str = str.replaceFirst(pattern1, "");
			if(str.endsWith(pattern2)) {
				answer = "DA";	
			}
		}
		return answer;
	}

}
