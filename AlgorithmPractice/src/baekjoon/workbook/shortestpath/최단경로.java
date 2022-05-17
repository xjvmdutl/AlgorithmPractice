package baekjoon.workbook.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최단경로 {
	static class Node implements Comparable<Node>{
		int index;
		int weight;
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	private static final int INF = 300001;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int v = Integer.parseInt(tokens.nextToken());
		int e = Integer.parseInt(tokens.nextToken());
		List<Node>[] map = getMap(v);
		int k = Integer.parseInt(reader.readLine()) - 1;
		for(int i=0;i<e;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			int weight = Integer.parseInt(tokens.nextToken());
			map[start].add(new Node(end, weight));
		}
		System.out.println(solution(map, v, k));
	}
	
	private static List<Node>[] getMap(int v) {
		List<Node>[] map = new ArrayList[v];
		for(int i=0;i<v;++i) {
			map[i] = new ArrayList<>();
		}
		return map;
	}
	
	private static String solution(List<Node>[] map, int v, int k) {
		int[] distances = dilkstra(map, v, k);
		return getResult(distances, v);
	}

	private static int[] dilkstra(List<Node>[] map, int v, int k) {
		int[] distances = new int[v];
		Arrays.fill(distances, INF);
		Queue<Node> que = new PriorityQueue<>();
		que.offer(new Node(k, 0));
		distances[k] = 0;
		while(!que.isEmpty()) {
			Node now = que.poll();
			for(Node next : map[now.index]) {
				if(distances[next.index] > distances[now.index] + next.weight) {
					distances[next.index] = distances[now.index] + next.weight;
					que.offer(new Node(next.index, distances[next.index]));
				}
			}
		}
		return distances;
	}

	private static String getResult(int[] distances, int v) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<v;++i) {
			if(distances[i] != INF) {
				answer.append(distances[i] + "\n");
			}else {
				answer.append("INF" + "\n");
			}
		}
		return answer.toString();
	}


}
