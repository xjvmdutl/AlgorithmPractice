package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACMCraft {
	public static int[] arr;
	public static int[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int k = Integer.parseInt(tokens.nextToken());
			int[] d= new int[n];
			tokens = new StringTokenizer(reader.readLine());
			List<Integer>[] map = new ArrayList[n];
			for(int i=0;i<n;++i) {
				map[i] = new ArrayList<Integer>();
				d[i] = Integer.parseInt(tokens.nextToken());
			}
			arr = new int[n];
			for(int i =0;i<k;++i) {
				tokens = new StringTokenizer(reader.readLine());
				int x = Integer.parseInt(tokens.nextToken()) - 1;
				int y = Integer.parseInt(tokens.nextToken()) - 1;
				arr[y]++;
				map[x].add(y);
			}
			int w = Integer.parseInt(reader.readLine())-1;
			System.out.println(solution(map, d, n, k, w));
		}
	}
	private static int solution(List<Integer>[] map, int[] d, int n, int k, int w) {
		visit = new int[n];
		topology(map, d, n, k, w);
		return visit[w];
	}
	private static void topology(List<Integer>[] map, int[] d, int n, int k, int w) {
		Queue<Integer> que = new LinkedList<>();
		for(int i=0;i<n;++i) {
			if(arr[i] == 0) {
				visit[i] = d[i];
				que.offer(i);
			}
		}
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				arr[next]--;
				visit[next] = Math.max(visit[next], visit[now] + d[next]);
				if(arr[next] == 0) {
					que.offer(next);
				}
			}
		}
		
	}

}
