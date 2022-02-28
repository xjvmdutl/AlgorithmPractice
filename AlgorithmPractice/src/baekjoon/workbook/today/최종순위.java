package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최종순위 {
	public static int[] teams;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			teams = new int[n];
			int[] arr = new int[n];
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			List<Integer>[] map = new ArrayList[n];
			for(int i=0;i<n;++i) {
				arr[i] = Integer.parseInt(tokens.nextToken()) - 1;
				map[i] = new ArrayList<Integer>();
			}
			for(int i=0;i<n;++i) {
				int from = arr[i];
				for(int j=i+1;j<n;++j) {
					map[from].add(arr[j]);
					teams[arr[j]]++;
				}
			}
			int m = Integer.parseInt(reader.readLine());
			for(int i=0;i<m;++i) {
				tokens = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokens.nextToken()) - 1;
				int end = Integer.parseInt(tokens.nextToken()) - 1;
				if(map[start].contains(end)) {
					Integer delete = end;
					map[start].remove(delete);
					map[end].add(start);
					teams[start]++;
					teams[end]--;
				}else {
					Integer delete = start;
					map[end].remove(delete);
					map[start].add(end);
					teams[end]++;
					teams[start]--;
				}
			}
			System.out.println(solution(map, arr, n, m));
		}
	}
	private static String solution(List<Integer>[] map, int[] arr, int n, int m) {
		return topology(map, n, m);
	}
	private static String topology(List<Integer>[] map, int n, int m) {
		Queue<Integer> que = new LinkedList<>();
		int count = 0;
		for(int i=0;i<n;++i) {
			if(teams[i] == 0) {
				count++;
				que.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;++i) {
			if(que.isEmpty()) {
				return "IMPOSSIBLE";
			}else {
				int now = que.poll();
				sb.append((now + 1) + " ");
				for(int next : map[now]) {
					teams[next]--;
					if(teams[next] == 0) {
						que.offer(next);
					}
				}
			}
		}
		return sb.toString();
	}

}
