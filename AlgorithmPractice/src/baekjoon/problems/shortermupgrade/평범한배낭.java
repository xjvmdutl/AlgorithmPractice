package baekjoon.problems.shortermupgrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//다시 풀기
public class 평범한배낭 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n,k));
	}

	private static int solution(int[][] arr, int n, int k) {
		int[][] dp = new int[n+1][k+1];
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=k;++j) {
				if(arr[i-1][0] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - arr[i-1][0]] + arr[i-1][1]);
				}
			}
		}
		return dp[n][k];
	}

}
