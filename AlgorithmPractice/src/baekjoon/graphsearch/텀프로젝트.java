package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ≈“«¡∑Œ¡ß∆Æ {
	public static boolean[] visit,dp;
	public static List<Integer> list;
	public static int start,answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			int n = Integer.parseInt(reader.readLine());
			int[] arr = new int[n];
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				arr[j] = Integer.parseInt(tokens.nextToken());
			}
			System.out.println(solution(n,arr));
		}
	}

	private static int solution(int n, int[] arr) {
		answer = 0;
		dp = new boolean[n];
		visit = new boolean[n];
		for(int i=0;i<n;++i) {
			start = i;
			if(!dp[i]) {
				list = new ArrayList<>();
				dfs(arr,arr[i]-1);
			}
		}
		
		return n - answer;
	}

	private static void dfs(int[] arr, int now) {
		if(visit[now])
			return;
		
		
		visit[now] = true;
		int next = arr[now] - 1;
		if(!visit[next]) {
			dfs(arr,next);
		}else {
			if(!dp[next]) {
                answer++;
                for(int i=next;i != now ; i = arr[i]-1) {
                	answer++;
                }
            }
		}
		dp[now] = true;
	}

}
