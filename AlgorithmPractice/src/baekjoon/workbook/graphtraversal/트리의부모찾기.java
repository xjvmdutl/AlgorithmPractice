package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
	private static final int ROOT = 0;
	private static boolean[] visit;
	private static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Integer>[] map = getMap(n);
		for(int i=0;i<n-1;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int start =  Integer.parseInt(tokens.nextToken()) - 1;
			int end =  Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
			map[end].add(start);
		}
		System.out.println(solution(map, n));
	}

	private static List<Integer>[] getMap(int n) {
		List<Integer>[] map = new ArrayList[n];
		for(int i = 0;i < n;++i) {
			map[i] = new ArrayList<Integer>();
		}
		return map;
	}
	
	private static String solution(List<Integer>[] map, int n) {
		int root = ROOT;
		visit = new boolean[n];
		parents = new int[n];
		dfs(map, root);
		return print();
	}

	private static void dfs(List<Integer>[] map, int now) {
		visit[now] = true;
		for(int next : map[now]) {
			if(!visit[next]) {
				parents[next] = now;
				dfs(map, next);
			}
		}
	}
	
	private static String print() {
		StringBuilder answer = new StringBuilder();
		for(int i=1;i<parents.length;++i) {
			answer.append((parents[i] + 1) + "\n");
		}
		return answer.toString();
	}
}
