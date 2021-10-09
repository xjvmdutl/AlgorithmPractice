package baekjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램 {
	public static int[] d;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int pd= Integer.parseInt(tokens.nextToken());
		List<Integer>[] list = new ArrayList[n];
		for(int i=0;i<n;++i)
			list[i] = new ArrayList<>();
		d = new int[n];
		for(int i=0;i<pd;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int count = Integer.parseInt(tokens.nextToken());
			int start = Integer.parseInt(tokens.nextToken())-1;
			for(int j=0;j<count-1;++j) {
				int now =Integer.parseInt(tokens.nextToken())-1;
				list[start].add(now);
				start = now;
				d[now]++;
			}
		}
		System.out.println(solution(list,n));
	}
	private static String solution(List<Integer>[] list, int n) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> result = new LinkedList<>();
		Queue<Integer> que = new LinkedList<>();
		for(int i=0;i<n;++i) {
			if(d[i] == 0) {
				que.offer(i);
			}
		}
		while(!que.isEmpty()) {
			int now = que.poll();
			result.offer(now);
			for(int next : list[now]) {
				d[next]--;
				if(d[next] == 0) {
					que.offer(next);
				}
			}
		}
		if(result.size() != n)
			sb.append(0);
		else {
			while(!result.isEmpty()) {
				sb.append((result.poll() + 1) + "\n");
			}
		}
		return sb.toString();
	}

}
