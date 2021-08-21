package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Node implements Comparable<Node>{
	int end;
	int weight;
	public Node(int end,int weight) {
		this.weight = weight;
		this.end = end;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}
public class 최단경로 {
	public static boolean[] visit;
	public static int[] dis;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int v = Integer.parseInt(tokens.nextToken());
		int e = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(reader.readLine()) - 1;
		List<Node>[] list = new ArrayList[v];
		for(int i=0;i<v;++i) {
			list[i] = new ArrayList<Node>();
		}
		for(int i=0;i<e;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			int weight = Integer.parseInt(tokens.nextToken());
			list[start-1].add(new Node(end-1, weight));
		}
		System.out.println(solution(list,k,v,e));
		
	}

	private static String solution(List<Node>[] list, int k, int v, int e) {
		StringBuilder sb = new StringBuilder();
		visit = new boolean[v];
		dis = new int[v];
		Arrays.fill(dis,Integer.MAX_VALUE);
		dis[k] = 0;
		dijkstra(list,k);
		for(int i : dis) {
			if(i == Integer.MAX_VALUE) {
				sb.append("INF" + "\n");
				continue;
			}
			sb.append(i + "\n");
		}
		return sb.toString();
	}

	private static void dijkstra(List<Node>[] list, int k) {
		Queue<Node> que = new PriorityQueue<Node>();
		que.offer(new Node(k, 0));
		
		while(!que.isEmpty()) {
			Node n = que.poll();
			if(visit[n.end])
				continue;
			visit[n.end] = true;
			for(Node node : list[n.end]) {
				if(dis[node.end] >  dis[n.end] + node.weight) {
					dis[node.end] = dis[n.end] + node.weight;
					que.offer(new Node(node.end, dis[node.end]));
				}
			}
			
		}
	}
}
