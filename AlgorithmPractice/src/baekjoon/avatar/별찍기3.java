package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class º°Âï±â3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(reader.readLine());
		System.out.println(solution(num));
	}

	private static String solution(int num) {
		StringBuilder sb = new StringBuilder();
		for(int i=num; i > 0 ;--i) {
			for(int j=0;j<i;++j) {
				sb.append("*");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
