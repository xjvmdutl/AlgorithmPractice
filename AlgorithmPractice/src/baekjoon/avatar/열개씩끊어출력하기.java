package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 열개씩끊어출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		StringBuilder sb = new StringBuilder();
		while(true) {
			if(str.length()>10) {
				sb.append(str.substring(0, 10) + "\n");
			}else {
				sb.append(str.substring(0, str.length()));
				break;
			}
			str = str.substring(10, str.length());
		}
		return sb.toString();
	}

}
