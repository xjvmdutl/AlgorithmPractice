package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 병사배치하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i]= Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[] arr, int n) {
		int[] dp = new int[n];
		int max = 1;
		Arrays.fill(dp, 1);
		for(int i=1;i<n;++i) {
			for(int j=0;j<i;++j) {
				if(arr[j] > arr[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			max = Math.max(dp[i], max);
		}
		int answer = arr.length - max;
		return answer;
	}

}
