package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {
	public static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n+1];
		for(int i=1;i<=n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		dp=new int[n+1];
		
		dp[1] = arr[1];
		if(n== 1) {
			return dp[1];
		}
		dp[2] = arr[1]+arr[2];
		if(n== 2) {
			return dp[2];
		}
		dp[3] = Math.max(arr[1]+arr[3], arr[2] + arr[3]);
		if(n== 3) {
			return dp[3];
		}
		for(int i=4;i<=n;++i) {
			dp[i] = Math.max(dp[i-3] + arr[i]+arr[i-1] , dp[i-2] + arr[i]);
		}
		return dp[n];
	}

}
