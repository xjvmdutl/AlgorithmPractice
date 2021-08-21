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
class Node01 implements Comparable<Node01>{
	int goal;
	int weight;
	public Node01(int goal,int weight) {
		this.goal = goal;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node01 o) {
		return this.weight - o.weight;
	}
	
}
public class 특정한최단경로 {
	
	public static int[] dist;
	public static final int INF = 99999999;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt(tokens.nextToken());
		int e = Integer.parseInt(tokens.nextToken());
		List<Node01>[] list = new ArrayList[n];
		for(int i=0;i<n;++i) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<e;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken())-1;
			int b = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken());
			list[a].add(new Node01(b,c));
			
			list[b].add(new Node01(a,c));
		}
		tokens = new StringTokenizer(reader.readLine());
		int v1 = Integer.parseInt(tokens.nextToken())-1;
		int v2 = Integer.parseInt(tokens.nextToken())-1;
		System.out.println(solution(list,v1,v2,n));
	}

	private static int solution(List<Node01>[] list, int v1, int v2, int n) {
		
		int answer = 0;
		int result1 = isOk(list,v1,v2,n);
		int result2 = isOk(list,v2,v1,n);
		if(result1 >= INF && result2 >= INF)
			return -1;
		else
			return Math.min(result1, result2);
	}

	private static int isOk(List<Node01>[] list, int v1, int v2, int n) {
		int result = 0;
		result += dijkstra(list,0,v1,n);
		result += dijkstra(list,v1,v2,n);
		result += dijkstra(list,v2,n-1,n);
		return result;
	}

	private static int dijkstra(List<Node01>[] list, int start, int end,int n) {
		dist = new int[n];
		Arrays.fill(dist, INF);
		Queue<Node01> que = new PriorityQueue<>();
		que.offer(new Node01(start, 0));
		dist[start] = 0;
		while(!que.isEmpty()) {
			Node01 no = que.poll();
			for(Node01 node : list[no.goal]) {
				if(dist[node.goal] > dist[no.goal] + node.weight ) {
					dist[node.goal] = dist[no.goal] + node.weight;
					que.offer(new Node01(node.goal, dist[node.goal]));
				}
			}
		}
		return dist[end];
	}

}
