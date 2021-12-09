package progammers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
class Texi implements Comparable<Texi>{
	int money;
	int next;
	public Texi(int money,int next) {
		this.money = money;
		this.next = next;
	}
	@Override
	public int compareTo(Texi o) {
		return this.money - o.money;
	}
}
public class 합승택시요금 {
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        
        List<Texi>[] map = new ArrayList[n];
        for(int i=0;i<n;++i)
        	map[i] = new ArrayList<>();
        for(int[] fare : fares) {
        	int start = fare[0] - 1;
        	int end = fare[1] - 1;
        	map[start].add(new Texi(fare[2],end));
        	map[end].add(new Texi(fare[2],start));
        }
        int[] disS = Dijkstra(map,s-1,n);
        int[] disA = Dijkstra(map,a-1,n);
        int[] disB = Dijkstra(map,b-1,n);
        int share = disS[a-1] + disS[b-1];
        final int INF = 100000 * 200;
        for (int i = 0; i < n; i++) {
          // 출발지에서 경유지로 가는 길이나 경유지에서 도착지로 가는 길이 하나라도 없으면 이동할 수 없음
          if (disS[i] == INF || disA[i] == INF || disB[i] == INF)
            continue;

          // 출발지에서 경유지 i까지 같이 가고, i에서부터 각자 도착지 A, B로 가는 경우의 수 중 최소값
          share = Math.min(share, disS[i] + disA[i] + disB[i]);
        }
        return share;
    }
	private static int[] Dijkstra(List<Texi>[] map, int s, int n) {
		int[] dis = new int[n];
		Arrays.fill(dis, 100000 * 200);
		Queue<Texi> pq = new PriorityQueue<>();
		pq.offer(new Texi(0, s));
		dis[s] = 0;
		while(!pq.isEmpty()) {
			Texi t = pq.poll();
			for(Texi next : map[t.next]) {
				if(dis[next.next] > dis[t.next] + next.money) {
					dis[next.next] = dis[t.next] + next.money;
					pq.offer(new Texi(dis[next.next], next.next));
				}
			}
		}
		return dis;
	}
	public static void main(String[] args) {
		//n	s	a	b	fares	result
		//6	4	6	2	[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]
		int n1 = 6;
		int s1 = 4;
		int a1 = 6;
		int b1 = 2;
		int[][] fare1 = {
		{4, 1, 10}
		, {3, 5, 24}
		, {5, 6, 2}
		, {3, 1, 41}
		, {5, 1, 24}
		, {4, 6, 50}
		, {2, 4, 66}
		, {2, 3, 22}
		, {1, 6, 25}};
		System.out.println(solution(n1,s1,a1,b1,fare1));
	}

}
