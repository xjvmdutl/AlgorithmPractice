package baekjoon.workbook.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú3 {
	private static final int MAX = 200001;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n, k));
	}

	private static int solution(int n, int k) {
		
		return bfs(n, k);
	}

	private static int bfs(int n, int k) {
		Queue<Integer> que = new LinkedList<>();
		int[] visit = new int[MAX];
		Arrays.fill(visit, MAX);
		visit[n] = 0;
		que.offer(n);
		while(!que.isEmpty()) {
			int now = que.poll();
			nextCheck(visit, now, que);
			preCheck(visit, now, que);
			teleportCheck(visit, now, que);
		}
		return visit[k];
	}



	private static void nextCheck(int[] visit, int now, Queue<Integer> que) {
		int next = now + 1;
		if(isRange(next) && visit[next] > visit[now] + 1) {
			visit[next] = visit[now] + 1;
			que.offer(next);
		}
	}

	private static void preCheck(int[] visit, int now, Queue<Integer> que) {
		int pre = now - 1;
		if(isRange(pre) && visit[pre] > visit[now] + 1) {
			visit[pre] = visit[now] + 1;
			que.offer(pre);
		}
	}
	private static void teleportCheck(int[] visit, int now, Queue<Integer> que) {
		int teleport = now * 2;
		if(isRange(teleport) && visit[teleport] > visit[now]) {
			visit[teleport] = visit[now];
			que.offer(teleport);
		}		
	}
	private static boolean isRange(int now) {
		return 0 <= now && now < MAX;
	}

}
