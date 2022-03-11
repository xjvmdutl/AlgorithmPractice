package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class ÅÒÇÁ·ÎÁ§Æ® {
	public static boolean[] visit, dp;
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			int[] arr = new int[n];
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int i=0;i<n;++i)
				arr[i] = Integer.parseInt(tokens.nextToken());
			System.out.println(solution(arr, n));
		}
	}

	private static int solution(int[] arr, int n) {
		answer = 0;
		visit= new boolean[n];
		dp = new boolean[n];
		for(int i=0;i<n;++i) {
			if(!dp[i]) {
				dfs(arr, arr[i] - 1);
			}
		}
		return n - answer;
	}

	private static void dfs(int[] arr, int index) {
		if(visit[index])
			return;
		visit[index] = true;
		int next = arr[index] - 1;
		if(!visit[next]) {
			dfs(arr, next);
		}else {
			if(!dp[next]) {
				answer++;
                for(int i=next;i != index ; i = arr[i]-1) {
                	answer++;
                }
			}
		}
		dp[index] = true;
	}

}
