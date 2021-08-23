package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수 {
	public static int[] dp = new int[46];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		dp[0] = 0;
		dp[1] = 1;
		if(n==0)
			return 0;
		else if(n == 1)
			return 1;
		int answer = Fibonachi(n-1) + Fibonachi(n-2);
		return answer;
	}

	private static int Fibonachi(int n) {
		if(n == 0) {
			return dp[1];
		}else if(n ==1) {
			return dp[2];
		}
			
		if(dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = Fibonachi(n-1) + Fibonachi(n-2);
	}

}
