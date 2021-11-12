package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class ¼û¹Ù²ÀÁú2 {
	public static StringBuilder sb;
	public static int time = Integer.MAX_VALUE;
	public static int[] visit = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		
		System.out.println(solution(n,k));
	}

	private static String solution(int n, int k) {
		sb = new StringBuilder();
		if (n >= k) {
			sb.append(n-k+"\n"+1);
            return sb.toString();
        }

		bfs(n,k);
		return sb.toString();
	}

	private static void bfs(int n, int k) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(n);
		visit[n] = 1;
		int answer = 0;
		while(!que.isEmpty()) {
			int now = que.poll();
			if(visit[now] > time) {
				break;
			}
			for(int i=0;i<3;++i) {
				int next;
                if (i == 0)         next = now + 1;
                else if (i == 1)    next = now - 1;
                else                next = now * 2;
				if(0 <= next && next <= 100000) {
					if(next == k) {
						time = visit[now];
						answer++;
					}
					if(visit[next] == 0 || visit[next] == visit[now] + 1) {
						que.offer(next);
						visit[next] = visit[now] + 1;
					}
				}
			}
		}
		sb.append(time + "\n");
		sb.append(answer);
	}

}
