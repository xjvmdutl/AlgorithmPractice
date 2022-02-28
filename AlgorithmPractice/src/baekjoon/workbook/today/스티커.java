package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ½ºÆ¼Ä¿ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			int[][] arr = new int[2][n];
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int i=0;i<n;++i) {
				arr[0][i] = Integer.parseInt(tokens.nextToken());
			}
			tokens = new StringTokenizer(reader.readLine());
			for(int i=0;i<n;++i) {
				arr[1][i] = Integer.parseInt(tokens.nextToken());
			}
			System.out.println(solution(arr, n));
		}
	}

	private static int solution(int[][] arr, int n) {
		int[][] dp = new int[2][n];
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		for(int i=1;i<n;++i) {
			//À§¿¡²¨ Á¦°Å
			dp[0][i] = dp[1][i-1] + arr[0][i];
			if(i >= 2) {
				dp[0][i] = Math.max(dp[0][i], Math.max(dp[0][i-2], dp[1][i-2]) + arr[0][i]);
			}
			//¹Ø¿¡²¨ Á¦°Å
			dp[1][i] = dp[0][i-1] + arr[1][i];
			if(i >= 2) {
				dp[1][i] = Math.max(dp[1][i], Math.max(dp[0][i-2], dp[1][i-2]) + arr[1][i]);
			}
		}
		return Math.max(dp[1][n-1], dp[0][n-1]);
	}

}
