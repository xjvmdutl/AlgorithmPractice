package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class ¼û¹Ù²ÀÁú {
	public static int[] dis;
	private static final int INF = 20001;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i)
			map[i] = new ArrayList<>();
		int[][] arr = new int[m][2];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
			map[end].add(start);
		}
		System.out.println(solution(map, n));
	}

	private static String solution(List<Integer>[] map, int n) {
		dis = new int[n];
		Arrays.fill(dis, INF);
		dilk(map, n);
		StringBuilder sb = new StringBuilder();
		int max = -1;
		int maxIdx = -1;
		for(int i=0;i<n;++i) {
			if(dis[i] == INF)
				continue;
			if(max < dis[i]) {
				maxIdx = i;
				max = dis[i];
			}
		}
		int count = 0;
		for(int i=0;i<n;++i) {
			if(dis[i] == max)
				count++;
		}
		sb.append((maxIdx+1) + " " + max + " "+ count);
		return sb.toString();
	}

	private static void dilk(List<Integer>[] map, int n) {
		Queue<Integer> que = new LinkedList<Integer>();
		dis[0] = 0;
		que.offer(0);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				if(dis[next] > dis[now] + 1) {
					dis[next] = dis[now] + 1;
					que.offer(next);
				}
			}
		}
	}

}
