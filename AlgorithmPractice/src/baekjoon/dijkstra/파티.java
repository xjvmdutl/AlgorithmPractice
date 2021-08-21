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
class Party implements Comparable<Party>{
	int goal;
	int time;
	public Party(int goal,int time) {
		this.goal = goal;
		this.time = time;
	}
	@Override
	public int compareTo(Party o) {

		return this.time - o.time;
	}
}
public class ÆÄÆ¼ {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken())-1;
		List<Party>[] list = new ArrayList[n];
		List<Party>[] reverseList = new ArrayList[n];
		for(int i=0;i<n;++i) {
			list[i] = new ArrayList<>();
			reverseList[i] = new ArrayList<>();
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken()) - 1;
			int e = Integer.parseInt(tokens.nextToken()) - 1;
			int t = Integer.parseInt(tokens.nextToken());
			list[s].add(new Party(e, t));
			reverseList[e].add(new Party(s, t));
		}
		System.out.println(solution(list,reverseList,n,x));
	}

	private static int solution(List<Party>[] list, List<Party>[] reverseList, int n, int x) {
		int answer = 0;
		int[] dist = new int[n];
		int[] revDist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(revDist, Integer.MAX_VALUE);
		dijkstra(list,x,n,dist);
		dijkstra(reverseList,x,n,revDist);
		for(int i=0;i<n;++i) {
			answer = Math.max(answer, dist[i] + revDist[i]);
		}
		return answer;
	}

	private static void dijkstra(List<Party>[] list, int s, int n, int[] dist) {
		Queue<Party> que = new PriorityQueue<>();
		que.offer(new Party(s, 0));
		dist[s] = 0;
		while(!que.isEmpty()) {
			Party p = que.poll();
			for(Party party : list[p.goal]) {
				if(dist[party.goal] > dist[p.goal] + party.time) {
					dist[party.goal] = dist[p.goal] + party.time;
					que.offer(new Party(party.goal, dist[party.goal]));	
				}
			}
		}
		
	}
	
}
