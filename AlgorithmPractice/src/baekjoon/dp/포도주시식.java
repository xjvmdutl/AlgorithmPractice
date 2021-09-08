package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {
	public static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}
	private static int solution(int[] arr, int n) {
		dp = new int[n];
		
		dp[0] = arr[0];
		if(n == 1) {
			return dp[0];
		}
		dp[1] = arr[1]+arr[0];
		if(n == 2) {
			return dp[1];
		}
		dp[2] = Math.max(Math.max(arr[0]+arr[1], arr[0]+arr[2]),arr[1]+arr[2]);
		if(n == 3) {
			return dp[2];
		}
		for(int i=3;i<n;++i) {
			dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]+arr[i]),arr[i-1] + dp[i-3] + arr[i]);
		}
		
		return dp[n-1];
	}
}
