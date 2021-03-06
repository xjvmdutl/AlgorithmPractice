package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ??Ʋ??Ʋȣ???ֹ???ȿ???? {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		long k = Long.parseLong(tokens.nextToken());
		long[] arr = new long[n+1];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=1;i<=n;++i) {
			arr[i] = Long.parseLong(tokens.nextToken());
		}
		System.out.println(solution(arr, n, k));
	}

	private static long solution(long[] arr, int n, long k) {
		long[] dp = new long[n+1];
		long sum = 0;
		for(int r=1, l=0;r<=n;++r) {
			sum += arr[r];
			dp[r] = dp[r-1];
			while(sum >= k) {
				dp[r] = Math.max(dp[r], dp[l] + sum - k);
				sum -= arr[++l];
			}
		}
		return dp[n];
	}

}
