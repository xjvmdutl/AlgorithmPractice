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
class Town2 implements Comparable<Town2>{
	int end;
	int weight;
	public Town2(int end,int weight) {
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Town2 o) {
		return this.weight - o.weight;
	}
}
public class 특정거리의도시찾기 {
	public static int[] distance;
	public static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());	
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken())-1;
		List<Town2>[] list = new ArrayList[n];
		for(int i=0;i<n;++i) {
			list[i]= new ArrayList<>();
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken()) - 1;
			int e = Integer.parseInt(tokens.nextToken()) - 1;
			list[s].add(new Town2(e, 1));
		}
		System.out.println(solution(list,n,k,x));
	}

	private static String solution(List<Town2>[] list, int n, int k, int x) {
		StringBuilder sb = new StringBuilder();
		distance = new int[n];
		visit = new boolean[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[x] = 0;
		dijkstra(list,x);
		for(int i=0;i<distance.length;++i) {
			if(distance[i] == k) {
				sb.append((i+1) + " ");
			}
		}
		if(sb.length() < 1) {
			sb.append("-1 ");
		}
		return sb.delete(sb.length()-1, sb.length()).toString();
	}

	private static void dijkstra(List<Town2>[] list, int x) {
		Queue<Town2> que = new PriorityQueue<>();
		que.offer(new Town2(x, 0));
		while(!que.isEmpty()) {
			Town2 t = que.poll();
			int cur = t.end;
			if(visit[cur]) continue;
			visit[cur] = true;
			for(Town2 town : list[cur]) {
				if(distance[town.end] > distance[cur] + town.weight) {
					distance[town.end] = distance[cur] + town.weight;
					que.offer(new Town2(town.end, distance[town.end]));
				}
			}
		}
	}

}
