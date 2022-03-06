package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수하나빼기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		long[] arr = new long[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static String solution(long[] arr, int n) {
		long answer = 0;
		long gcdValue = 0;
		long[] leftGcd = new long[n+2];
		leftGcd[1] = arr[0];
		long[] rightGcd = new long[n+2];
		rightGcd[n] = arr[n-1];
		for(int i=1;i<=n;++i) {
			leftGcd[i] = GCD(Math.max(leftGcd[i-1], arr[i-1]), Math.min(leftGcd[i-1], arr[i-1]));
		}
		for(int i=n-1;i>0;--i) {
			rightGcd[i] = GCD(Math.max(rightGcd[i+1], arr[i-1]), Math.min(rightGcd[i+1], arr[i-1]));
		}
		for(int i=1;i<=n;++i) {
			long gcd = GCD(Math.max(leftGcd[i-1], rightGcd[i+1]), Math.min(leftGcd[i-1], rightGcd[i+1]));
			if(answer < gcd && arr[i-1] % gcd != 0) {
				answer = gcd;
				gcdValue = arr[i-1];
			}
		}
		if(answer == 0 && gcdValue == 0) {
			return "-1";
		}
		return answer + " " + gcdValue;
	}

	private static long GCD(long x, long y) {
		if(y == 0) {
			return x;
		}
		return GCD(y, x%y);
	}

}
