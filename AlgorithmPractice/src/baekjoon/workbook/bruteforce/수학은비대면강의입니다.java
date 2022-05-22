package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학은비대면강의입니다 {

	private static String solution(int a, int b, int c, int d, int e, int f) {
		StringBuilder answer = new StringBuilder();
		OUTER:for(int x=-999; x <= 999; ++x) {
			for(int y=-999; y <= 999; ++y) {
				boolean isCalculateOkay1 = calculate(a*x , b * y, c);
				boolean isCalculateOkay2 = calculate(d*x , e * y, f);
				if(isCalculateOkay1 && isCalculateOkay2) {
					answer.append(x + " " + y);
					break OUTER;
				}
			}	
		}
		return answer.toString();
	}
	private static boolean calculate(int a, int b, int c) {
		return a + b == c;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokens.nextToken());
		int b = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int d = Integer.parseInt(tokens.nextToken());
		int e = Integer.parseInt(tokens.nextToken());
		int f = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(a, b, c, d, e, f));
	}


}
