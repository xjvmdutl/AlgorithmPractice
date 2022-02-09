package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌다리건너기 {
	private static final int ANGEL = 0, DEVIL = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String magicScroll = reader.readLine();
		String devilBridge = reader.readLine();
		String angelBridge = reader.readLine();
		System.out.println(solution(magicScroll, devilBridge, angelBridge));
	}

	private static int solution(String magicScroll,String angelBridge,String devilBridge) {
		int N = angelBridge.length();
		int M = magicScroll.length();
		int[][][] dp = new int[2][angelBridge.length()][magicScroll.length()];
		if(angelBridge.charAt(0) == magicScroll.charAt(0))
			dp[ANGEL][0][0] = 1;
		if(devilBridge.charAt(0) == magicScroll.charAt(0))
			dp[DEVIL][0][0] = 1;
		for(int i=1;i<N;++i) {
			dp[ANGEL][i][0] = angelBridge.charAt(i) == magicScroll.charAt(0) 
					? dp[ANGEL][i-1][0] + 1 : dp[ANGEL][i-1][0];
			for(int j=1;j<magicScroll.length();++j) {
				dp[ANGEL][i][j] = angelBridge.charAt(i) == magicScroll.charAt(j)
						? dp[ANGEL][i-1][j] + dp[DEVIL][i-1][j-1] : dp[ANGEL][i-1][j];
			}
			dp[DEVIL][i][0] = devilBridge.charAt(i) == magicScroll.charAt(0) 
					? dp[DEVIL][i-1][0] + 1 : dp[DEVIL][i-1][0];
			for(int j=1;j<magicScroll.length();++j) {
				dp[DEVIL][i][j] = devilBridge.charAt(i) == magicScroll.charAt(j)
						? dp[DEVIL][i-1][j] + dp[ANGEL][i-1][j-1] : dp[DEVIL][i-1][j];
			}
		}
		
		return dp[ANGEL][N-1][M-1] + dp[DEVIL][N-1][M-1];
	}

}
