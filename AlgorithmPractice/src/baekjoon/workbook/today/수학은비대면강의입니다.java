package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학은비대면강의입니다 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokens.nextToken());
		int b = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int d = Integer.parseInt(tokens.nextToken());
		int e = Integer.parseInt(tokens.nextToken());
		int f = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(a,b,c,d,e,f));
	}

	private static String solution(int a, int b, int c, int d, int e, int f) {
		StringBuilder sb = new StringBuilder();
		for(int i=-999;i<=999;++i) {
			for(int j=-999;j<=999;++j) {
				if(c == a * i + b *j && f == d * i + e *j) {
					sb.append(i + " " + j);
					break;
				}
			}	
		}
		return sb.toString();
	}

	private static int gcd(int x, int y) {
		if(y <= 1)
			return x;
		return gcd(x, y%x);
	}

}
