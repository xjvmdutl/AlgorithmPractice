package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
	public static boolean[] visit;
	public static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;++i) {
			list.add(new ArrayList<Integer>());
		}
		for(int i=0;i<n-1;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n1 = Integer.parseInt(tokens.nextToken()) - 1;
			int n2 = Integer.parseInt(tokens.nextToken()) - 1;
			list.get(n1).add(n2);
			list.get(n2).add(n1);
		}
		System.out.println(solution(list,n));
	}
	private static String solution(List<ArrayList<Integer>> list, int n) {
		visit = new boolean[n];
		parent = new int[n];
		parent[0] = 1;
		visit[0] = true;
		bfs(list,n);
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<parent.length;++i) {
			sb.append((parent[i] + 1) + "\n");
		}
		return sb.toString();
	}
	private static void bfs(List<ArrayList<Integer>> list, int n) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(0);
		while(!que.isEmpty()) {
			int p = que.poll();
			for(int i=0;i<list.get(p).size();++i) {
				if(!visit[list.get(p).get(i)]) {
					que.offer(list.get(p).get(i));
					visit[list.get(p).get(i)] = true;
					parent[list.get(p).get(i)] = p;
				}
			}
		}
	}
	
}
