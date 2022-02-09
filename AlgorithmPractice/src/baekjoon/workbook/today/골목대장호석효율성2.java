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
class Money implements Comparable<Money>{
	int node;
	long money;
	public Money(int node, long money) {
		this.money = money;
		this.node = node;
	}
	@Override
	public int compareTo(Money o) {
		return Long.compare(this.money, o.money);
	}
}
public class 골목대장호석효율성2 {
	public static long[] dis;
	public static long max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int a = Integer.parseInt(tokens.nextToken()) - 1;
		int b = Integer.parseInt(tokens.nextToken()) - 1;
		long c = Long.parseLong(tokens.nextToken());
		List<Money>[] map = new ArrayList[n];
		for(int i=0;i<map.length;++i) {
			map[i] = new ArrayList<>();
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			long money = Long.parseLong(tokens.nextToken());
			max = Math.max(money, max);
			map[start].add(new Money(end, money));
			map[end].add(new Money(start, money));
		}
		System.out.println(solution(map, n, a, b, c));
	}

	private static long solution(List<Money>[] map, int n, int a, int b, long c) {
		long answer = Long.MAX_VALUE;
		long start = 0;
		long end = max;
		while(start <= end) {
			long mid = (start + end ) / 2; //수치심
			dijk(map,n,a,b,c,mid);
			if(dis[b] <= c) {
				answer = Math.min(mid, answer);
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return answer == Long.MAX_VALUE ? -1 : answer;
	}

	private static void dijk(List<Money>[] map, int n, int a, int b, long c, long shame) {
		dis = new long[n];
		Arrays.fill(dis, Long.MAX_VALUE);
		Queue<Money> pq = new PriorityQueue<>();
		pq.offer(new Money(0, a));
		dis[a] = 0;
		while(!pq.isEmpty()) {
			Money now = pq.poll();
			if(dis[now.node] < now.money)
				continue;
			for(Money next : map[now.node]) {
				if(shame >= next.money && dis[next.node] > dis[now.node] + next.money) {
					dis[next.node] = dis[now.node] + next.money;
					pq.offer(new Money(next.node, dis[next.node]));
				}
			}
		}
		
		
	}

}
