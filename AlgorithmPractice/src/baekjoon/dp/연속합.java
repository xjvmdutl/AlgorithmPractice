package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¿¬¼ÓÇÕ {
	public static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int answer = arr[0];
		dp = new int[n];
		dp[0] = arr[0];
		for(int i=1;i<n;++i) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			answer = Math.max(answer, dp[i]);
		}
		
		return answer;
	}

}
