package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Goal implements Comparable<Goal>{
	int end;
	int weight;
	public Goal(int end,int weight) {
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Goal o) {
		return this.weight - o.weight;
	}
	
}
public class 미확인도착지 {
	public static int[] distance;
	public static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		while(T-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int m = Integer.parseInt(tokens.nextToken());
			int t = Integer.parseInt(tokens.nextToken());
			tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken())-1;
			int g = Integer.parseInt(tokens.nextToken())-1;
			int h = Integer.parseInt(tokens.nextToken())-1;
			List<Goal>[] list = new ArrayList[n];
			for(int i=0;i<n;++i)
				list[i] = new ArrayList<>();
			for(int i=0;i<m;++i) {
				tokens = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokens.nextToken())-1;
				int end = Integer.parseInt(tokens.nextToken())-1;
				int weight = Integer.parseInt(tokens.nextToken());
				if((start == g && end == h) || (start == h && end == g)) {
					list[start].add(new Goal(end, weight*2-1));
					list[end].add(new Goal(start, weight*2-1));
				}else {
					list[start].add(new Goal(end, weight*2));
					list[end].add(new Goal(start, weight*2));
				}
			}
			int[] trr = new int[t];
			for(int i=0;i<t;++i) {
				int x = Integer.parseInt(reader.readLine())-1;
				trr[i] =x;
			}
			
			System.out.println(solution(list,s,g,h,n,trr));
		}
	}

	private static String solution(List<Goal>[] list, int s, int g, int h, int n, int[] trr) {
		distance = new int[n];
		visit = new boolean[n];
		Arrays.fill(distance, Integer.MAX_VALUE-1);
		distance[s] = 0;
		Dijkstra(list,s,n);
		StringBuilder sb= new StringBuilder();
		Arrays.sort(trr);
		int idx = 0;
		for(int i=0;i<distance.length;++i) {
			if(i == trr[idx]) {
				if(distance[i] % 2 == 1) {
					sb.append(i+1 + " ");
				}
				idx++;
				if(idx >= trr.length)
					break;
			}
		}
		return sb.delete(sb.length()-1,sb.length()).toString();
	}
	
	private static void Dijkstra(List<Goal>[] list, int start, int n) {
		Queue<Goal> que = new PriorityQueue<>();
		que.offer(new Goal(start, 0));
		while(!que.isEmpty()) {
			Goal g = que.poll();
			int cur = g.end;
			if(visit[cur])
				continue;
			visit[cur] = true;
			for(Goal goal : list[cur]) {
				if(distance[goal.end] > distance[cur] + goal.weight) {
					distance[goal.end] = distance[cur] + goal.weight;
					que.offer(new Goal(goal.end,distance[goal.end]));
				}
			}
		}
	}

}
