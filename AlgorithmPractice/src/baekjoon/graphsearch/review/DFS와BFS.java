package baekjoon.graphsearch.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS��BFS {
	public static boolean[] visit;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);
		int v = Integer.parseInt(strs[2]);
		List<Integer>[] list = new ArrayList[n];
		for(int i=0;i<n;++i) {
			list[i] = new ArrayList<>();//list �ʱ�ȭ
		}
		for(int i=0;i<m;++i){
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken())-1;//���� Index�� 1����
			int end = Integer.parseInt(tokens.nextToken())-1;
			//��������� ��� �����־�� �Ѵ�.
			list[end].add(start);
			list[start].add(end);
		}
		for(int i=0;i<n;++i) {
			Collections.sort(list[i]);//���� ��ȣ���� Ž���ϱ� ������
		}
		System.out.println(solution(list,n,v));
	}

	private static String solution(List<Integer>[] list, int n, int v) {
		int start = v-1;//���� Index�� �ϳ� �۱� ������
		visit = new boolean[n];//�湮 ���� �ʱ�ȭ
		sb = new StringBuilder();
		sb.append((start+1) + " ");//ù�湮
		visit[start] = true;
		dfs(list,n,start);//DFS
		
		sb.append("\n");
		
		visit = new boolean[n];
		sb.append((start+1) + " ");
		visit[start] = true;
		bfs(list,n,start);//BFS
		return sb.toString();
	}

	private static void bfs(List<Integer>[] list, int n, int start) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		while(!que.isEmpty()) {
			int node = que.poll();
			for(int idx : list[node]) {
				if(!visit[idx]) {
					visit[idx] = true;
					sb.append((idx+1) + " ");
					que.offer(idx);
				}
			}
		}
	}

	private static void dfs(List<Integer>[] list, int n, int v) {
		for(int i: list[v]) {
			if(!visit[i]) {
				visit[i] = true;
				sb.append((i+1) + " ");
				dfs(list, n, i);
			}
		}
	
	}
}
