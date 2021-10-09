package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Tube{
	int next;
	long k;
	public Tube(int next,long k) {
		this.k = k;
		this.next = next;
	}
}
public class MooTube {
	public static boolean[] visit;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int q = Integer.parseInt(tokens.nextToken());
		List<Tube>[] list = new ArrayList[n];
		for(int i=0;i<n;++i) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<n-1;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken())-1;
			int end = Integer.parseInt(tokens.nextToken())-1;
			long weight = Integer.parseInt(tokens.nextToken());
			list[start].add(new Tube(end, weight));
			list[end].add(new Tube(start, weight));
		}
		long[][] questions = new long[q][2];
		for(int i=0;i<q;++i) {
			tokens = new StringTokenizer(reader.readLine());
			long k = Integer.parseInt(tokens.nextToken());
			long now = Integer.parseInt(tokens.nextToken())-1;
			questions[i][0] = k;
			questions[i][1] = now;
		}
		System.out.println(solution(list,n,questions));
	}

	private static String solution(List<Tube>[] list, int n, long[][] questions) {
		sb = new StringBuilder();
		for(int i=0;i<questions.length;++i) {
			visit = new boolean[n];
			long k = questions[i][0];
			long v = questions[i][1];
			bfs(list, n,k,v);
		}
		return sb.toString();
	}

	private static void bfs(List<Tube>[] list, int n, long k, long v) {
		Queue<Tube> que = new LinkedList<>();
		que.offer(new Tube((int) v, 1000000001));
		visit[(int) v] = true;
		int count = 0;
		while(!que.isEmpty()) {
			Tube t = que.poll();
			for(Tube tube : list[t.next]) {
				if(!visit[tube.next] && tube.k >= k) {
					visit[tube.next] = true;
					que.offer(new Tube(tube.next, tube.k));
					count++;
				}
			}
		}
		sb.append(count + "\n");
	}
}
