package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스 {
	private static final int START = 0;
	private static boolean[] visit;
	private static int answer;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<m;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
			map[end].add(start);
		}
		System.out.println(solution(map, n, m));
	}

	private static int solution(List<Integer>[] map, int n, int m) {
		int virus = START;
		answer = 0;
		visit = new boolean[n];
		visit[virus] = true;
		dfs(map, virus);
		return answer;
	}

	private static void dfs(List<Integer>[] map, int now) {	
		for(int next : map[now]) {
			if(!visit[next]) {
				visit[next] = true;
				answer++;
				dfs(map, next);
			}
		}
	}

}
