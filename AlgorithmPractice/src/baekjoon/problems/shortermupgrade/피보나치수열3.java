package baekjoon.problems.shortermupgrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수열3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(reader.readLine());
		//피사노 주기 : 피보나치 수열을 일정 값으로 나눌경우 일정 주기가 생긴다.
		//10^6 으로 나눈값들의 피보나치 주기 = 15 * 10^5
		System.out.println(solution(n));
	}

	private static int solution(long n) {
		int[] dp = new int[1500001];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<=1500000;++i) {
			dp[i] = (dp[i-2] + dp[i-1])%1000000;
		}
		return dp[(int) (n%1500000)];
	}

}
