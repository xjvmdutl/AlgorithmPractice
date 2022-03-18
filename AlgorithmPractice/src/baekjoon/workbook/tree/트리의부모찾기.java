package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
	public static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		parents = new int[n];
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<>();
		}
		for(int i=0;i<n-1;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
			map[end].add(start);
		}
		dfs(map, 0);
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<n;++i)
			sb.append(parents[i] + "\n");
		System.out.println(sb.toString());
	}
	private static void dfs(List<Integer>[] map, int node) {
		for(int next : map[node]) {
			if(parents[next] == 0) {
				parents[next] = (node + 1);
				dfs(map, next);
			}
		}
	}

}
