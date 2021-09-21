package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Επ»η {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		int[] dp = new int[16];
		int result = 0;
		for(int i=1;i<=n;++i) {
			int t = arr[i-1][0];
			int p = arr[i-1][1];
			if(i + t > n+1)
				continue;
			if(dp[i] == 0)
				dp[i] = result;
			dp[i+t] = Math.max(dp[i+t], dp[i] + p);
			result = Math.max(dp[i], result);
		}
		result = Math.max(dp[n+1], result);
		return result;
	}

}
