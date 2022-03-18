package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팰린드롬 {
	public static boolean[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n+1];
		StringBuilder sb = new StringBuilder();
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=1;i<=n;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		solution(arr, n);
		int m = Integer.parseInt(reader.readLine());
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken());
			int e = Integer.parseInt(tokens.nextToken());
			 if(dp[s][e]) 
				 sb.append("1\n");
            else 
            	sb.append("0\n");
		}
		System.out.println(sb.toString());
	}

	private static void solution(int[] arr, int n) {
		dp = new boolean[n+1][n+1];
		for(int i=1;i<=n;++i)
			dp[i][i] = true; //길이 1 모두 펠린드롭
		for(int i=1;i<=n-1;++i) {
			//길이 2
			if(arr[i] == arr[i+1]) {
				dp[i][i+1] = true;
			}
		}
		
		for(int i = 2; i < n; i++){
            for(int j = 1; j <= n - i; j++){
                if(arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }
	}
}