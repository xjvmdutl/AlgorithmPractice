package baekjoon.stepbystep.print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class °ö¼À {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());
		System.out.println(solution(a,b));
	}

	private static String solution(int a, int b) {
		StringBuilder sb= new StringBuilder();
		int sum = 0;
		int idx = 0;
		while(b>0) {
			int n = b%10;
			b/=10;
			sb.append((a * n) + "\n" );
			sum += a*n * (Math.pow(10, idx++));
		}
		sb.append(sum);
		return sb.toString();
	}

}
