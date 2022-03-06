package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {
	public static int answer;
	public static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		dp = new int[31][31];
		for(int i=1;i<=30;++i) {
			dp[i][0] = 1;
			for(int j=1;j<i;++j) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}	
			dp[i][i] = 1;
		}

		while(t-- > 0 ) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int m = Integer.parseInt(tokens.nextToken());
			System.out.println(solution(n, m));
		}
	}

	private static int solution(int n, int m) {
		answer = dp[m][n];
		return answer;
	}

}
