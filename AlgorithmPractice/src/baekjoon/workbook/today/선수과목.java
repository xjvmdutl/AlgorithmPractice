package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 선수과목 {
	public static int[] arr;
	public static int count;
	public static int[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		arr= new int[n];
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i)
			map[i] = new ArrayList<>();
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken()) - 1;
			int b = Integer.parseInt(tokens.nextToken()) - 1;
			arr[b]++;
			map[a].add(b);
		}
		System.out.println(solution(map, n, m));
	}
	private static String solution(List<Integer>[] map, int n, int m) {
		StringBuilder sb = new StringBuilder();
		visit = new int[n];
		count = 1;
		while(topology(map, n, m)) {
			count++;
		}
		for(int i=0;i<n;++i) {
			sb.append(visit[i]+" ");
		}
		return sb.toString();
	}
	private static boolean topology(List<Integer>[] map, int n, int m) {
		Queue<Integer> que = new LinkedList<>();
		for(int i=0;i<n;++i) {
			if(visit[i] == 0 && arr[i] == 0) {
				visit[i] = count;
				que.offer(i);
			}
		}
		if(que.size() == 0) {
			return false;
		}
		int size= que.size();
		for(int i=0;i<size;++i) {
			int now = que.poll();
			for(int next : map[now]) {
				arr[next]--;
			}
		}
		return true;
	}

}
