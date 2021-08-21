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
class Cost implements Comparable<Cost>{
	int goal;
	int cost;
	public Cost(int goal,int cost) {
		this.cost = cost;
		this.goal = goal;
	}
	@Override
	public int compareTo(Cost o) {
		return this.cost - o.cost;
	}
}
public class 최소비용구하기 {
	public static int[] dist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		List<Cost>[] list = new ArrayList[n];
		for(int i=0;i<n;++i) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<m;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken())-1;
			int e = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken());
			list[s].add(new Cost(e,c));
		}
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int start = Integer.parseInt(tokens.nextToken())-1;
		int end = Integer.parseInt(tokens.nextToken())-1;
		System.out.println(solution(list,start,end,n));
	}

	private static int solution(List<Cost>[] list, int start, int end, int n) {
		int answer = 0;
		dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		bfs(list,start,end);
		answer = dist[end];
		
		return answer;
	}

	private static void bfs(List<Cost>[] list, int start, int end) {
		Queue<Cost> que = new PriorityQueue<Cost>();
		que.offer(new Cost(start, 0));
		while(!que.isEmpty()) {
			Cost c = que.poll();
			if(dist[c.goal] < c.cost)
				continue;
			for(Cost cost : list[c.goal]) {
				if(dist[cost.goal] > cost.cost + dist[c.goal]) {
					dist[cost.goal] = cost.cost + dist[c.goal];
					que.offer(new Cost(cost.goal, dist[cost.goal]));
				}
			}
		}
	}

}
