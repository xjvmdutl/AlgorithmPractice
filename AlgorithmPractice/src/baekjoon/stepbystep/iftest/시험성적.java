package baekjoon.stepbystep.iftest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시험성적 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(reader.readLine());
		System.out.println(solution(num));
	}

	private static String solution(int num) {
		StringBuilder sb = new StringBuilder();
		if(90 <= num && num <= 100)
			sb.append("A");
		else if(80 <= num && num < 90)
			sb.append("B");
		else if(70 <= num && num < 80)
			sb.append("C");
		else if(60 <= num && num < 70)
			sb.append("D");
		else
			sb.append("F");
		return sb.toString();
	}

}
