package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú4 {
	public static int[] visit = new int[100001];
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,k));
	}

	private static String solution(int n, int k) {
		sb = new StringBuilder();
		if(n >= k) {
			sb.append(n-k+"\n");
			for(int i=n;i>=k;--i) {
				sb.append(i + " ");
			}
			return sb.toString();
		}
		bfs(n,k);
		return sb.toString();
	}

	private static void bfs(int n, int k) {
		Queue<Integer> que = new LinkedList<>();
		Arrays.fill(visit, Integer.MAX_VALUE);
		visit[n] = n;
		que.offer(n);
		while(!que.isEmpty()) {
			int now = que.poll();
			if(now == k) {
				Stack<Integer> stack = new Stack<>();
				stack.push(k);
				while(visit[k] != k) {
					stack.push(visit[k]);
					k=visit[k];
				}
				sb.append(stack.size()-1 + "\n");
				while(!stack.isEmpty()) {
					sb.append(stack.pop() + " ");
				}
				return;
			}
			for(int i=0;i<3;++i) {
				int next;
				if(i==0)
					next = now+1;
				else if(i==1)
					next = now-1;
				else
					next = now * 2;
				if(0 <= next && next <= 100000) {
					if(visit[next] == Integer.MAX_VALUE ) {
						que.offer(next);
						visit[next] = now;
					}
				}
			}
		}
	}

}
