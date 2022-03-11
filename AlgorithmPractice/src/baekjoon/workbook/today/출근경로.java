package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 출근경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int w = Integer.parseInt(tokens.nextToken());
		int h = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(w, h));
	}
	private static final int MOD = 100000;
	private static int solution(int w, int h) {
		
		int[][][][] dp = new int[w][h][2][2];
		for(int i=0;i<w;++i)
			dp[i][0][0][0] = 1;
		for(int i=0;i<h;++i)
			dp[0][i][1][0] = 1;
		for(int i=1;i<w;++i) {
			for(int j=1;j<h;++j) {
				dp[i][j][1][0] = (dp[i][j - 1][1][1] + dp[i][j - 1][1][0]) % MOD;
                dp[i][j][1][1] = dp[i][j - 1][0][0] % MOD;
                dp[i][j][0][0] = (dp[i - 1][j][0][0] + dp[i - 1][j][0][1]) % MOD;
                dp[i][j][0][1] = dp[i - 1][j][1][0] % MOD;
			}
		}	
		int result = (dp[w-1][h-1][0][0] + dp[w-1][h-1][0][1] + dp[w-1][h-1][1][0] + dp[w-1][h-1][1][1]) % MOD; 
		return result;
	}

}
