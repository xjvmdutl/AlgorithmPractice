package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ÀÛ¾÷ {
	public static boolean[] visit;
	public static int answer;
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
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[end].add(start);
		}
		int x = Integer.parseInt(reader.readLine()) - 1;
		System.out.println(solution(map, n, m, x));
	}
	private static int solution(List<Integer>[] map, int n, int m, int x) {
		answer = 0;
		visit = new boolean[n];
		topology(map, n, m ,x );
		return answer;
	}
	private static void topology(List<Integer>[] map, int n, int m, int x) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(x);
		visit[x] = true;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				if(!visit[next]) {
					visit[next] = true;
					answer++;
					que.offer(next);
				}
			}
		}
	}
}
