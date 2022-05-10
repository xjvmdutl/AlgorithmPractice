package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú3 {
	private final static int MAX = 200002;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n, k));
	}

	private static int solution(int n, int k) {
		int answer = bfs(n, k);
		return answer;
	}

	private static int bfs(int n, int k) {
		int[] visit = new int[MAX];
		Arrays.fill(visit, MAX);
		Queue<Integer> que = new LinkedList<>();
		que.offer(n);
		visit[n] = 0;
		while(!que.isEmpty()) {
			int subin = que.poll();
			subinGo(que, visit, subin);
			subinBack(que, visit, subin);
			subinTeleportation(que, visit, subin);
			
		}
		return visit[k];
	}

	private static void subinGo(Queue<Integer> que, int[] visit, int x) {
		if(isRange(x + 1) && visit[x] < visit[x+1]) {
			visit[x + 1] = visit[x] + 1;
			que.offer(x + 1);
		}
	}


	private static void subinTeleportation(Queue<Integer> que, int[] visit, int x) {
		if(isRange(x * 2) && visit[x] < visit[x * 2]) {
			visit[x * 2] = visit[x];
			que.offer(x * 2);
		}
	}

	private static void subinBack(Queue<Integer> que, int[] visit, int x) {
		if(isRange(x - 1) && visit[x] < visit[x - 1]) {
			visit[x - 1] = visit[x] + 1;
			que.offer(x - 1);
		}
	}

	private static boolean isRange(int n) {
		return 0 <= n && n < MAX;
	}

}
