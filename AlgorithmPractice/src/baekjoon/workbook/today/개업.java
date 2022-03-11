package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 개업 {
	private static final int INF = 10001;
	private static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[m];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<m;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr, n, m));
	}

	private static int solution(int[] arr, int n, int m) {
		int answer = 0;
		Set<Integer> set = new HashSet<>();
		for(int i=1;i<=2;++i) {
			//조합 구하기
			visit = new boolean[n];
			permulate(arr, set, 0, 0, i);
		}
		int[] dp = new int[n+1];
		Arrays.fill(dp, INF);
		for(int num : set) {
			if(num <= n) {
				dp[num] = 1;
			}
		}
		for(int i=0;i<=n;++i) {
			if(set.contains(i))
				continue;
			int min = INF;
			for(int num : set) {
				if(i - num > 0 && dp[i - num] != INF) {
					min = Math.min(dp[i - num] + 1, min);
				}
			}
			dp[i] = min;
		}
		return dp[n] == INF ? -1 : dp[n];
	}

	private static void permulate(int[] arr, Set<Integer> set, int sum, int count, int length) {
		if(count == length) {
			set.add(sum);
			return;
		}
		for(int i=0;i<arr.length;++i) {
			if(!visit[i]) {
				visit[i] = true;
				permulate(arr, set, sum + arr[i], count + 1, length);
				visit[i] = false;
			}
		}
	}
}
