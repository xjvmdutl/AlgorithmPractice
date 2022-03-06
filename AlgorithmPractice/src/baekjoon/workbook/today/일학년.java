package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¿œ«–≥‚ {
	public static long[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static long solution(int[] arr, int n) {
		long answer = 0;
		dp = new long[21];
		dp[arr[0]] = 1;
		cal(arr, 0, n);
		return dp[arr[n-1]];
	}

	private static void cal(int[] arr, int count, int n) {
		if(count == n - 2) {
			return;
		}
		long[] tmp = new long[21];
		for(int i=0;i<=20;++i) {
			if(dp[i] != 0) {
				if(i - arr[count+1] >= 0) {
					tmp[i - arr[count+1]] += dp[i];
				}
				if(i + arr[count+1] <= 20) {
					tmp[i + arr[count+1]] += dp[i];
				}
			}
		}
		dp = tmp.clone();
		cal(arr, count+1, n);
	}

}
