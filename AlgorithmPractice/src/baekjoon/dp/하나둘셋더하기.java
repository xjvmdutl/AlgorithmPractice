package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하나둘셋더하기 {
	public static int[] dp = new int[12];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=0;i<t;++i) {
			String number = reader.readLine();
			System.out.println(solution(Integer.parseInt(number)));
		}
	}

	private static int solution(int n) {
		int answer = 0;
		//1 = 1
		//2 = 1+1 , 2
		//3 = 1+1+1, 2+1, 1+2, 3
		//4 = 1+3
		if(dp[n] != 0) {
			return dp[n];
		}
		for(int i=4;i<=n;++i) {
			if(dp[i] != 0)
				continue;
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1]; 
		}
		return dp[n];
	}
}
