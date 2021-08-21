package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Elevate{
	int now;
	int count;
	public Elevate(int now,int count) {
		this.count = count;
		this.now = now;
	}
}
public class 스타트링크 {
	public static boolean[] visit;
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int F = Integer.parseInt(tokens.nextToken());
		int S = Integer.parseInt(tokens.nextToken());
		int G = Integer.parseInt(tokens.nextToken());
		int U = Integer.parseInt(tokens.nextToken());
		int D = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(F, S, G, U, D));
	}


	private static String solution(int f, int s, int g, int u, int d) {
		answer = -1;
		visit = new boolean[f];
		bfs(f,s,g,u,d);
		return answer == -1 ? "use the stairs" : String.valueOf(answer);
	}

	private static void bfs(int f, int s, int g, int u, int d) {
		Queue<Elevate> que = new LinkedList<>();
		que.offer(new Elevate(s-1, 0));
		visit[s-1] = true;
		while(!que.isEmpty()) {
			Elevate e = que.poll();
			if(e.now == g-1) {
				answer = e.count;
				break;
			}
			//up
			int up = e.now + u;
			if(isRange(up,f) && !visit[up]) {
				visit[up] = true;
				que.offer(new Elevate(up, e.count+1));
			}
			//down
			int down = e.now - d;
			if(isRange(down,f) && !visit[down]) {
				visit[down] = true;
				que.offer(new Elevate(down, e.count+1));
			}
		}
	}


	private static boolean isRange(int now, int f) {
		if(now >= f || now < 0)
			return false;
		return true;
	}

}
