package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Bridge{
	int node;
	int weight;
	public Bridge(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}
public class 트리의기둥과가지 {
	public static boolean[] visit;
	public static int length;
	public static int bridge;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		List<Bridge>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<>();
		}
		for(int i=0;i<n-1;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			int length = Integer.parseInt(tokens.nextToken());
			map[start].add(new Bridge(end, length));
			map[end].add(new Bridge(start, length));
		}
		System.out.println(solution(map, n, r-1));
	}

	private static String solution(List<Bridge>[] map, int n, int r) {
		visit = new boolean[n];
		length = 0;
		bridge = 0;
		visit[r] = true;
		int giga = r;
		if(map[r].size() == 1) {
			int next = map[r].get(0).node;
			visit[next] = true;
			length += map[r].get(0).weight;
			giga = findGiga(map, next);
		}
		find(map, giga, 0);
		StringBuilder sb = new StringBuilder();
		sb.append(length + " " + bridge);
		return sb.toString();
	}

	private static void find(List<Bridge>[] map, int giga, int l) {
		bridge = Math.max(bridge, l);
		visit[giga] = true;
		for(Bridge b : map[giga]) {
			if(!visit[b.node]) {
				find(map, b.node, b.weight + l);
			}
		}
	}

	private static int findGiga(List<Bridge>[] map, int root) {
		if(map[root].size() == 2) {
			for(Bridge b : map[root]) {
				if(!visit[b.node]) {
					visit[b.node] = true;
					length += b.weight;
					return findGiga(map, b.node);
				}
			}
		}
		return root;
	}

}
