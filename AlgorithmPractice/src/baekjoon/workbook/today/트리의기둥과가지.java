package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Tree {
	int end;
	int bridge;
	public Tree(int end, int bridge) {
		this.bridge = bridge;
		this.end = end;
	}
	
	
}
public class 트리의기둥과가지 {
	public static boolean[] visit;
	public static int giga;
	public static int[] dis;
	public static int max;
	public static boolean first;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken()) -1;
		List<Tree>[] map = new ArrayList[n];
		for(int i=0;i<n;++i)
			map[i]= new ArrayList<>();
		for(int i=0;i<n-1;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken()) -1;
			int b = Integer.parseInt(tokens.nextToken()) -1;
			int bridge = Integer.parseInt(tokens.nextToken());
			map[a].add(new Tree(b, bridge));
			map[b].add(new Tree(a, bridge));

		}
		System.out.println(solution(map, n, r));
	}

	private static String solution(List<Tree>[] map, int n, int r) {
		dis = new int[n];
		visit = new boolean[n];
		giga = 0;
		first = true;
		max = 0;
		visit[r] = true;
		if(map[r].size() == 1) {
			visit[map[r].get(0).end] = true;
			giga = map[r].get(0).bridge;
			dfs(map, giga, map[r].get(0).end, n);
		}else {
			giga = 0;
			first = false;
			for(Tree next : map[r]) {
				if(!visit[next.end]) {
					visit[next.end] = true;
					dfs(map, 0 + next.bridge, next.end, n);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(giga + " ");
		sb.append(max - giga);
		return sb.toString();
	}

	private static void dfs(List<Tree>[] map, int length, int r, int n) {
		max = Math.max(length, max);
		if(map[r].size() != 2 && first) {
			first = false;
			giga = length;
		}
		for(Tree next : map[r]) {
			if(!visit[next.end]) {
				visit[next.end] = true;
				dfs(map, length + next.bridge, next.end, n);
			}
		}
	}

	private static int find(List<Tree>[] map,int count, int r, int n) {
		if(map[r].size() == 1) {
			return find(map, count+ map[r].get(0).bridge, map[r].get(0).end, n);
		}
		return count;
	}
}
