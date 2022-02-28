package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Elevate implements Comparable<Elevate>{
	int now;
	int count;
	public Elevate(int now, int count) {
		this.count = count;
		this.now = now;
	}
	@Override
	public int compareTo(Elevate o) {
		return this.count - o.count;
	}
}
public class 스타트링크 {
	public static boolean[] visit;
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int f = Integer.parseInt(tokens.nextToken());
		int s = Integer.parseInt(tokens.nextToken());
		int g = Integer.parseInt(tokens.nextToken());
		int u = Integer.parseInt(tokens.nextToken());
		int d = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(f, s, g, u, d));
	}

	private static String solution(int f, int s, int g, int u, int d) {
		answer = Integer.MAX_VALUE;
		visit = new boolean[f+1];
		bfs(f, g, s, u, d);
		return answer == Integer.MAX_VALUE ? "use the stairs" : String.valueOf(answer);
	}

	private static void bfs(int f, int g, int s, int u, int d) {
		Queue<Elevate> pq = new PriorityQueue<>();
		pq.offer(new Elevate(s, 0));
		visit[s] = true;
		int[] dir = new int[2];
		dir[0] = u;
		dir[1] = -d;
		while(!pq.isEmpty()) {
			Elevate e = pq.poll();
			if(e.now == g) {
				answer = e.count;
				return;
			}
			for(int i=0;i<2;++i) {
				int now = e.now + dir[i];
				if(isRange(now, f) && !visit[now]) {
					visit[now] = true;
					pq.offer(new Elevate(now, e.count + 1));
				}	
			}
		}
	}

	private static boolean isRange(int next, int f) {
		return 1 <= next && next <= f;
	}
}
