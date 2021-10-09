package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú4 {
	public static boolean[] visit;
	public static int[] parents;
	public static StringBuilder sb;
	public static int[] dx = {-1,1,2};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,k));
	}
	private static String solution(int n, int k) {
		sb = new StringBuilder();
		visit = new boolean[100001];
		parents = new int[100001];
		bfs(n,k);
		int now = k;
		List<Integer> list = new ArrayList<>();
		while(now != n) {
			list.add(now);
			now = parents[now];
		}
		sb.append(list.size() + "\n");
		sb.append(n + " ");
		for(int i=list.size()-1 ;i>=0;--i) {
			sb.append(list.get(i) + " ");
		}
		return sb.toString();
	}
	private static void bfs(int n, int k) {
		Queue<Integer> que = new LinkedList<>();
		visit[n] = true;
		parents[n] = n;
		que.offer(n);
		while(!que.isEmpty()) {
			int now = que.poll();
			if(now == k) {
				break;
			}
			for(int i=0;i<3;++i) {
				int nx;
				if(i == 2) {
					nx = now * dx[i];
				}else {
					nx = now + dx[i];	
				}
				if(0 <= nx && nx < visit.length && !visit[nx]) {
					visit[nx] = true;
					que.offer(nx);
					parents[nx] = now;
				}
			}
		}
	}

}
