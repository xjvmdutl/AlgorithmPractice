package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¾ËÆÄºªÃ£±â {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
		
	}

	private static String solution(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i='a';i<='z';++i) {
			int idx = str.indexOf(i);
			sb.append(idx + " ");
		}
		return sb.toString();
	}

}
