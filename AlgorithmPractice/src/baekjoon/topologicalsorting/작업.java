package baekjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ÀÛ¾÷ {
	public static int[] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Integer>[] list = new ArrayList[n];
		d= new int[n];
		int[] works = new int[n];
		for(int i=0;i<n;++i)
			list[i] = new ArrayList<>();
		
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			works[i] = Integer.parseInt(tokens.nextToken());
			int m = Integer.parseInt(tokens.nextToken());
			for(int j=0;j<m;++j) {
				int now = Integer.parseInt(tokens.nextToken())-1;
				list[now].add(i);
				d[i]++;
			}
		}
		System.out.println(solution(list,works,n));
	}
	private static int solution(List<Integer>[] list, int[] works, int n) {
		int answer = 0;
		Queue<Integer> que = new LinkedList<>();
		int[] result = new int[n];
		for(int i=0;i<n;++i) {
			result[i] = works[i];
			if(d[i] == 0)
				que.offer(i);
		}
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : list[now]) {
				d[next]--;
				result[next] = Math.max(result[next], result[now] + works[next]);
				if(d[next] == 0)
					que.offer(next);
			}
		}
		for(int i=0;i<n;++i) {
			answer = Math.max(answer, result[i]);
		}
		
		return answer;
	}

}
