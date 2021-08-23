package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그대로출력하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while((str = reader.readLine()) != null) {
			System.out.println(solution(str));
		}
	}

	private static String solution(String str) {
		return str;
	}

}
