package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {
	public static int[] degree;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		degree = new int[n];
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i)
			map[i] = new ArrayList<>();
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken())-1;
			int end = Integer.parseInt(tokens.nextToken())-1;
			map[start].add(end);
			degree[end]++;
		}
		System.out.println(solution(map,n));
	}
	private static String solution(List<Integer>[] map, int n) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		for(int i=0;i<n;++i) {
			if(degree[i] == 0)
				que.offer(i);
		}
		while(!que.isEmpty()) {
			int now = que.poll();
			result.offer(now+1);
			for(int next : map[now]) {
				degree[next]--;
				if(degree[next] == 0)
					que.offer(next);
			}
		}
		while(!result.isEmpty()) {
			sb.append(result.poll() + " ");
		}
		return sb.toString();
	}

}
