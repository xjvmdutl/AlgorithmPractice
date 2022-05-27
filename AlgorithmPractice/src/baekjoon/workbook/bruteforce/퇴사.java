package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Επ»η {
	
	private static int solution(int[][] arr, int n) {
		
		int[] dp = new int[n+1];
		for(int i=0;i<n;++i) {
			int time = arr[i][0] + i;
			int price = arr[i][1] + dp[i];
			if(time > n ) {
				continue;
			}
			for(int j=time;j<=n;++j) {
				dp[j] = Math.max(dp[j], price);
			}
		}
	
		return getMaxTime(dp, n);
	}
	
	private static int getMaxTime(int[] dp, int n) {
		int result = 0;
		for(int i=0;i<=n;++i) {
			result = Math.max(result, dp[i]);
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n =  Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

}
