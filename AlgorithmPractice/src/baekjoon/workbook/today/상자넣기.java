package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 상자넣기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens =  new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int max = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<=i;++j) {
				if(arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
