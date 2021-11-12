package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú3 {
	public static int[] visit = new int[100001];
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,k));
	}

	private static int solution(int n, int k) {
		answer = Integer.MAX_VALUE;
		if(n >= k) {
			answer = n - k;
			return answer;
		}
		bfs(n,k);
		return answer;
	}

	private static void bfs(int n, int k) {
		Queue<Integer> que = new LinkedList<>();
		Arrays.fill(visit, Integer.MAX_VALUE);
		visit[n] = 0;
		que.offer(n);
		while(!que.isEmpty()) {
			int now = que.poll();
			if(now == k) {
				answer = Math.min(answer, visit[k]);
				continue;
			}
			for(int i=0;i<3;++i) {
				int next;
				int count;
				if(i==0) {
					next = now + 1;
					count = visit[now] + 1;
				}else if(i==1) {
					next = now - 1;
					count = visit[now] + 1;
				}else {
					next = now * 2;
					count = visit[now];
				}
				if(next < 0 || next > 100000)
					continue;
				if(visit[next] > count) {
					visit[next] = count;
					que.offer(next);
				}
			}
		}
	}

}
