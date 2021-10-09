package baekjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발 {
	public static int[] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Integer>[] list = new ArrayList[n];
		d = new int[n];
		for(int i=0;i<n;++i) {
			list[i] = new ArrayList<>();	
		}
		int[] buildTimses = new int[n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			buildTimses[i] = Integer.parseInt(tokens.nextToken());
			while(true) {
				int num = Integer.parseInt(tokens.nextToken());
				if(num == -1)
					break;
				list[num-1].add(i);
				d[i]++;
			}
		}
		System.out.println(solution(list,buildTimses,n));
	}
	private static String solution(List<Integer>[] list, int[] buildTimses, int n) {
		int[] result = new int[n];
		Queue<Integer> que= new LinkedList<>();
		for(int i=0;i<n;++i) {
			result[i] = buildTimses[i];
			if(d[i] == 0) {
				que.offer(i);
			}
		}
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : list[now]) {
				result[next] = Math.max(result[next], result[now] + buildTimses[next]);
				d[next]--;
				if(d[next] == 0) {
					que.offer(next);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;++i) {
			sb.append(result[i] + "\n");
		}
		return sb.toString();

	}

}
