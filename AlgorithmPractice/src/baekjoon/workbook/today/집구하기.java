package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Home implements Comparable<Home>{
	int v;
	int distance;
	public Home(int v,int distance) {
		this.v = v;
		this.distance = distance;
	}
	@Override
	public int compareTo(Home o) {
		return this.distance - o.distance;
	}
}
public class 집구하기 {
	private final static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int e = Integer.parseInt(tokens.nextToken());
		List<Home>[] map =new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<>();
		}
		for(int i=0;i<e;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(tokens.nextToken()) - 1;
			int v = Integer.parseInt(tokens.nextToken()) - 1;
			int w = Integer.parseInt(tokens.nextToken());
			map[u].add(new Home(v, w));
			map[v].add(new Home(u, w));
		}
		tokens = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken());
		int[] madonaldo = new int[m];
		tokens = new StringTokenizer(reader.readLine());
		
		for(int i=0;i<m;++i) {
			madonaldo[i] = Integer.parseInt(tokens.nextToken()) - 1;
		}
		tokens = new StringTokenizer(reader.readLine());
		int s = Integer.parseInt(tokens.nextToken());
		int y = Integer.parseInt(tokens.nextToken());
		int[] starbucks = new int[s];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<s;++i) {
			starbucks[i] = Integer.parseInt(tokens.nextToken()) - 1;
		}
		
		System.out.println(solution(map, n, e, madonaldo, m, x, starbucks, s, y));
	}

	private static int solution(List<Home>[] map, int n, int e, int[] madonaldo, int m, int x, int[] starbucks,
			int s, int y) {
		int answer = INF;
		int[] mcDis = new int[n];
		Arrays.fill(mcDis, INF);
		Queue<Home> pq = new PriorityQueue<>();
		for(int i=0;i<madonaldo.length;++i) {
			mcDis[madonaldo[i]] = 0;
			pq.offer(new Home(madonaldo[i], 0));
		}
		dilk(map, pq, mcDis);
		
		
		int[] sbDis = new int[n];
		Arrays.fill(sbDis, INF);
		pq.clear();
		for(int i=0;i<starbucks.length;++i) {
			sbDis[starbucks[i]] = 0;
			pq.offer(new Home(starbucks[i], 0));
		}
		dilk(map, pq, sbDis);
		for(int i=0;i<n;++i) {
			
			if(0 < mcDis[i] && mcDis[i] <= x
					&& 0 < sbDis[i] && sbDis[i] <= y) {
				answer = Math.min(answer, sbDis[i] + mcDis[i]);

			}
		}
		return answer == INF ? -1 : answer;
	}

	private static void dilk(List<Home>[] map, Queue<Home> pq, int[] dis) {
		while(!pq.isEmpty()) {
			Home now = pq.poll();
			for(Home next : map[now.v]) {
				if(dis[next.v] > now.distance + next.distance) {
					dis[next.v] = now.distance+ next.distance;
					pq.offer(new Home(next.v, dis[next.v]));
				}
			}
		}
	}

}
