package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class 효율적인해킹 {
	public static int[] cnt;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		List<Integer>[] list = new ArrayList[n];
		for(int i=0;i<n;++i)
			list[i] = new ArrayList<>();
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken())-1;
			int end = Integer.parseInt(tokens.nextToken())-1;
			list[start].add(end);
		}
		System.out.println(solution(list,n));
	}

	private static String solution(List<Integer>[] list, int n) {
		cnt = new int[n];
		for(int i=0;i<n;++i) {
			visit = new boolean[n];
			dfs(list,i);
		}
		int max = 0;
		for(int i=0;i<cnt.length;++i) {
			max = Math.max(max, cnt[i]);
		}
		StringBuilder sb = new StringBuilder(); 
		for(int i=0;i<cnt.length;++i) {
			if(cnt[i] == max) {
				 sb.append((i + 1) + " ");
			}
		}
		return sb.toString();
	}

	private static void dfs(List<Integer>[] list, int now) {
		visit[now] = true;
		for(int number : list[now]) {
			if(!visit[number]) {
				cnt[number]++;
				dfs(list, number);
			}
		}
	}

}
