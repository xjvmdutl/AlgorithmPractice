package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ÆÓ¸°µå·Ò¼ö {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str = reader.readLine()) != null) {
			if(Integer.parseInt(str) == 0)
				break;
			System.out.println(solution(str));
		}
	}

	private static String solution(String str) {
		String answer = "yes";
		for(int i=0;i<str.length()/2;++i) {
			char first = str.charAt(i);
			char last = str.charAt(str.length() - i - 1);
			if(first != last) {
				return "no";
			}
		}
		return answer;
	}

}
