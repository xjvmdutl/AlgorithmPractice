package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {
	private static final int FOUR = 4;
	private static boolean[] visit;
	private static boolean isVisit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<>();
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			map[start].add(end);
			map[end].add(start);
		}
		System.out.println(solution(map, n, m));
	}

	private static String solution(List<Integer>[] map, int n, int m) {
		isVisit = false;
		for(int i=0;i<n;++i) {
			visit = new boolean[n];
			visit[i] = true;
			dfs(map, 0, i);
			if(isVisit) {
				return "1";
			}
		}
		return "0";
	}

	private static void dfs(List<Integer>[] map, int count, int now) {
		
		if(count >= FOUR) {
			isVisit = true;
			return;
		}
		for(int next : map[now]) {
			if(!visit[next]) {
				visit[next] = true;
				dfs(map, count + 1, next);
				visit[next] = false;
			}
		}
	}

	

}
