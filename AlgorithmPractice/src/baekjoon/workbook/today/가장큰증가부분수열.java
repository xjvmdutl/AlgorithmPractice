package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[] arr, int n) {
		/**
		 * 5
		 * 5 1 2 3 10
		 */
		int[] dp = new int[n];
		int answer = arr[0];
		dp[0] = arr[0];
		for(int i=1;i<n;++i) {
			dp[i] = arr[i];
			for(int j=0;j<i;++j) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
			answer = Math.max(dp[i], answer);
		}
		return answer;
	}

}
