package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
class Town implements Comparable<Town>{
	int end;
	int weight;
	public Town(int end,int weight) {
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Town o) {
		return this.weight - o.weight;
	}
	
}
public class 최소비용구하기2 {
	public static int[] dis;
	public static boolean[] visit;
	public static int[] parents;
	public static int cityCnt;
	public static Stack<Integer> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Town>[] list = new ArrayList[n];
		for(int i=0;i<n;++i) {
			list[i] = new ArrayList<>();
		}
		int m = Integer.parseInt(reader.readLine());
		for(int i=0;i<m;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken()) - 1;
			int e = Integer.parseInt(tokens.nextToken()) - 1;
			int w = Integer.parseInt(tokens.nextToken());
			list[s].add(new Town(e,w));
		}
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int start = Integer.parseInt(tokens.nextToken()) - 1;
		int end = Integer.parseInt(tokens.nextToken()) - 1;
		System.out.println(solution(list,n,start,end));
	}

	private static String solution(List<Town>[] list, int n, int start, int end) {
		StringBuilder sb= new StringBuilder();
		dis = new int[n];
		visit = new boolean[n];
		parents = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		Dijkstra(list,n,start,end);
		
		stack = new Stack<>();
		search(start,end);
		stack.push(start+1);
		cityCnt = stack.size();
		sb.append(dis[end] + "\n");
		sb.append(cityCnt + "\n");
        while(!stack.isEmpty()){
            int city = stack.pop();
            sb.append(city + " ");
        }
		
		
		return sb.toString();
	}

	 private static void search(int start, int now) {
		 if(now != start) {
			 stack.push(now + 1);
			 search(start, parents[now]);
		 }
	}

	private static void Dijkstra(List<Town>[] list, int n, int start, int end) {
		Queue<Town> que = new PriorityQueue<Town>();
		que.offer(new Town(start, 0));
		dis[start] = 0;
		while(!que.isEmpty()) {
			Town t = que.poll();
			int cur = t.end;
			if(visit[cur])
				continue;
			visit[cur] = true;
			for(Town town : list[cur]) {
				if(dis[town.end] > dis[cur] + town.weight) {
					dis[town.end] = dis[cur] + town.weight;
					que.offer(new Town(town.end, dis[town.end]));
					parents[town.end] = cur;
				}
			}
		}
	}

}
