package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Internet implements Comparable<Internet>{
	int goal;
	int cost;
	public Internet(int goal,int cost) {
		this.cost = cost;
		this.goal = goal;
	}
	@Override
	public int compareTo(Internet o) {
		return this.cost - o.cost;
	}
	
}
public class 인터넷설치 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int p = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		List<Internet>[] map = new ArrayList[n];
		for(int i=0;i<n;i++) {
			map[i] = new ArrayList<>();
		}
		for(int i=0;i<p;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int n1 = Integer.parseInt(tokens.nextToken()) - 1;
			int n2 = Integer.parseInt(tokens.nextToken()) - 1;
			int cost = Integer.parseInt(tokens.nextToken());
			map[n1].add(new Internet(n2,cost));
			map[n2].add(new Internet(n1,cost));
		}
		System.out.println(solution(map,n,k));
	}

	private static int solution(List<Internet>[] map, int n, int k) {
		int answer = Integer.MAX_VALUE;
		int start = 0;
		int end = 1000000;
		while(start <= end) {
			int mid = (start+end)/2;
			if(dijstra(map,n,k,mid)) {
				answer = mid;
				end = mid - 1;
			}else {
				start = mid+1;
			}
		}
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	private static boolean dijstra(List<Internet>[] map, int n, int k, int mid) {
		Queue<Internet> pq = new PriorityQueue<>();
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		pq.offer(new Internet(0, 0));
		while(!pq.isEmpty()) {
			Internet i = pq.poll();
			for(Internet internet : map[i.goal]) {
				int cost = internet.cost <= mid ? 0 : 1;
				if(dist[internet.goal] > i.cost + cost) {
					dist[internet.goal] = i.cost + cost;
					pq.offer(new Internet(internet.goal, dist[internet.goal]));
				}
			}
		}
		return dist[n-1] <= k;
	} 

}
