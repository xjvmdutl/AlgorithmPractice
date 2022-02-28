package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ±ÿ¿Â¡¬ºÆ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		int[] vips = new int[m];
		for(int i=0;i<m;++i) {
			vips[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(vips, n, m));
	}

	private static int solution(int[] vips, int n, int m) {
		int answer = 1;
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=n;++i) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		int start = 0;
		for(int i=0;i<m;++i) {
			int end = vips[i];
			answer *= dp[end - start - 1];
			start = end;
		}
		answer*= dp[n - start];
		return answer;
	}

}
