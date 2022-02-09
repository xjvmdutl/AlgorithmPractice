package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 밀비급일 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str = reader.readLine()) != null) {
			if (str.equals("END")) {
				break;
			}
			System.out.println(solution(str));
		}
	}

	private static String solution(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}

}
