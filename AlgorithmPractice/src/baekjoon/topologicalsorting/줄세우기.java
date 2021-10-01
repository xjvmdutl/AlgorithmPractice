package baekjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {
	public static Queue<Integer> result;
	public static int[] indegree;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		List<List<Integer>> list = new ArrayList<>();
		indegree = new int[n+1];
		for(int i=0;i<=n;++i) {
			list.add(new ArrayList<>());
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			list.get(a).add(b);
			indegree[b]++;
		}
		System.out.println(solution(list,n));
	}
	private static String solution(List<List<Integer>> list, int n) {
		StringBuilder sb = new StringBuilder();
		result = new LinkedList<>();
		Queue<Integer> que = new LinkedList<>();
		for(int i=1;i<indegree.length;++i) {
			if(indegree[i] == 0) {
				que.offer(i);
			}
		}
		while(!que.isEmpty()) {
			int now = que.poll();
			result.offer(now);
			for(int next :list.get(now)) {
				indegree[next]--;
				if(indegree[next] == 0)
					que.offer(next);
			}
		}
		
		while(!result.isEmpty()) {
			sb.append(result.poll() + " ");
		}
		return sb.toString();
	}

}
