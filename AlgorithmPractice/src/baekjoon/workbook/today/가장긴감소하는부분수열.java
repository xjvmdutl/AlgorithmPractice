package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * DP 사용
 * @author KimJunHo
 *
 */
public class 가장긴감소하는부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		int[] dp = new int[n]; 
		for(int i=0;i<arr.length;++i) {
			dp[i] = 1;
			for(int j=i-1;j>=0;--j) {
				if(arr[i] < arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			answer = Math.max(answer, dp[i]);
		}
		return answer;
	}

}
