package baekjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¹®Á¦Áý {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int link[] = new int[n];
		List<Integer>[] list = new ArrayList[n];
		for(int i=0;i<n;++i) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken())-1;
			int b = Integer.parseInt(tokens.nextToken())-1;
			list[a].add(b);
			link[b]++;
		}
		System.out.println(solution(list,n,link));
	}

	private static String solution(List<Integer>[] list, int n, int[] link) {
		StringBuilder sb= new StringBuilder();
		Queue<Integer> que = new PriorityQueue<>();
		for(int i=0;i<link.length;++i) {
			if(link[i] == 0)
				que.offer(i);
		}
		while(!que.isEmpty()) {
			int now = que.poll();
			sb.append((now+1) + " ");
			for(int next : list[now]) {
				link[next]--;
				if(link[next] == 0)
					que.offer(next);
			}
		}
		
		
		return sb.toString();
	}

}
