package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú {
	public static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,k));
	}

	private static int solution(int n, int k) {
		int answer = 0;
		if(n==k)
			return answer;
		visited = new int[100001];
		Queue<Integer> que = new LinkedList<>();
		que.offer(n);
		visited[n] = 1;
		while(!que.isEmpty()) {
			int data = que.poll();
			for(int i=0;i<3;++i) {
				int next;
				if(i == 0) 
					next = data + 1;
				else if(i == 1)
					next = data - 1;
				else
					next = data * 2;
				if(next == k) {
					return visited[data];
				}
				if(next > 0 && next < visited.length && visited[next] == 0) {
					visited[next] = visited[data] + 1;
					que.offer(next);
				}
			}
		}
		return answer;
	}
}
