package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,m));
	}

	private static String solution(int n, int m) {
		StringBuilder sb = new StringBuilder();
		int gcd = GCD(n,m);
		int gbd = (n*m)/gcd;
		sb.append(gcd + "\n");
		sb.append(gbd + "\n");
		return sb.toString();
	}

	private static int GCD(int x, int y) {
		if(x == 0)
			return y;
		return GCD(y%x, x);
	}

}
