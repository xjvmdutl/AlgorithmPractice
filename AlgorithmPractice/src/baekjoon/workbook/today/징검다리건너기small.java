package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 징검다리건너기small {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n, k));
	}

	private static String solution(int[] arr, int n, int k) {
		boolean[] dp = new boolean[n];
		dp[0] = true;
		for(int i=0;i<n;++i) {
			if(dp[i]) {
				for(int j=i+1;j<n;++j) {
					int result = (j - i) * (1 + Math.abs(arr[i] - arr[j]));
					if(result <= k)
						dp[j] = true;
				}
				if(dp[n-1])
					break;
			}
		}
		return dp[n-1] ? "YES" : "NO";
	}
}
