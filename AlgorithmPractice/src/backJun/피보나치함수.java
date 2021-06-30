package backJun;

import java.util.Arrays;
import java.util.Scanner;

public class 피보나치함수 {
	static Integer[][] dp = new Integer[41][2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		for(int i=0;i<t;++i) {
			int n = sc.nextInt();
			fibonacci(n);
			System.out.println(dp[n][0] + " " +dp[n][1]);
		}
	}

	

	private static Integer[] fibonacci(int n) {
		if(dp[n][0] == null || dp[n][1] == null) {
			dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
			dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
		}
    	return dp[n];
	}

	

}
