package baekjoon.problems.algorithmPratice;

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
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		return this.weight - weight;
	}
}
public class 최소비용구하기 {
	public static int[] dis;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		List<Node>[] map = new ArrayList[n];
		for(int i=0;i<n;++i)
			map[i] = new ArrayList<>();
		for(int i=0;i<m;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken())-1;
			int end = Integer.parseInt(tokens.nextToken())-1;
			int weight = Integer.parseInt(tokens.nextToken());
			map[start].add(new Node(end, weight));
		}
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int start = Integer.parseInt(tokens.nextToken())-1;
		int end = Integer.parseInt(tokens.nextToken())-1;
		System.out.println(solution(map,start,end,n));
	}

	private static int solution(List<Node>[] map, int start, int end, int n) {
		dis = new int[n];
		dijk(map,start,end);
		return dis[end];
	}

	private static void dijk(List<Node>[] map, int start, int end) {
		Queue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;
		pq.offer(new Node(start,0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(dis[now.end] < now.weight)
				continue;
			for(Node next : map[now.end]) {
				if(dis[next.end] > dis[now.end] + next.weight) {
					dis[next.end] = dis[now.end] + next.weight;
					pq.offer(new Node(next.end,dis[next.end]));
				}
			}
		}
		
		
	}

}
