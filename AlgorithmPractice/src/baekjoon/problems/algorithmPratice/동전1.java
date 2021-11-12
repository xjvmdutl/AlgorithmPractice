package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class µ¿Àü1 {
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n,k));
	}

	private static int solution(int[] arr, int n, int k) {
		int[] dp = new int[k + 1];
        dp[0] = 1;

        for(int i = 0 ; i < n; i++) {
            for (int j = arr[i]; j <= k; j++)
                dp[j] += dp[j - arr[i]];
        }
		return dp[k];
	}

}
