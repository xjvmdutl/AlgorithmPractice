package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 실행시간 {
	public static int[] waiting;
	public static int answer;
	public static int[] arr;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		waiting = new int[n];
		arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			waiting[i] = Integer.parseInt(tokens.nextToken());
			map[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
			arr[end]++;
		}
		System.out.println(solution(map, n, m, k));
	}
	private static int solution(List<Integer>[] map, int n, int m, int k) {
		answer = Integer.MAX_VALUE;
		visit = new boolean[n];
		permutation(map, n, m, 0, k);
		
		return answer;
	}
	private static void permutation(List<Integer>[] map, int n, int m, int count, int k) {
		if(count == k) {
			int time = topology(map, n, m, k);
			answer = Math.min(answer, time);
			return;
		}
		for(int i=1;i<arr.length-1;++i) {
			if(!visit[i]) {
				int now = waiting[i];
				waiting[i] = 0;
				visit[i] = true;
				permutation(map, now, m, count+1, k);
				waiting[i] = now;
				visit[i] = false;
			}
		}
	}
	private static int topology(List<Integer>[] map, int n, int m, int k) {
		Queue<Integer> que = new LinkedList<>();
		int[] arrV = arr.clone();
		que.offer(0);
		int time = waiting[0];
		while(!que.isEmpty()) {
			int now = que.poll();
			int max = 0;
			for(int next : map[now]) {
				arrV[next]--;
				if(arrV[next] == 0) {
					max = Math.max(max, waiting[next]);
					que.offer(next);
				}
			}
			time += max;
		}
		return time;
	}

}
