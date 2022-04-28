package baekjoon.workbook.topology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACMCraft {
	public static int[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int k = Integer.parseInt(tokens.nextToken());
			int[] arr = new int[n];
			int[] builds = new int[n];
			List<Integer>[] map = new ArrayList[n];
			tokens = new StringTokenizer(reader.readLine());
			for(int i = 0;i<n;++i) {
				map[i] = new ArrayList<>();
				builds[i] = Integer.parseInt(tokens.nextToken());
			}
			for(int i = 0;i < k;++i) {
				tokens = new StringTokenizer(reader.readLine());
				int x = Integer.parseInt(tokens.nextToken()) - 1;
				int y = Integer.parseInt(tokens.nextToken()) - 1;
				map[x].add(y);
				arr[y]++;
			}
			int w = Integer.parseInt(reader.readLine()) - 1;
			System.out.println(solution(map, builds, arr, n, k, w));
		}
	}

	private static int solution(List<Integer>[] map, int[] builds, int[] arr, int n, int k, int w) {
		visit = new int[n];
		Queue<Integer> que = getQueue(arr, builds, n);
		int answer = topology(map, builds, arr, que, n, k, w);
		return answer;
	}


	private static Queue<Integer> getQueue(int[] arr, int[] builds, int n) {
		Queue<Integer> que = new LinkedList<>();
		for(int i=0;i<n;++i) {
			visit[i] = builds[i];
			if(isZero(arr[i])) {
				que.offer(i);
			}
		}
		return que;
	}

	private static boolean isZero(int num) {
		return num == 0;
	}
	
	private static int topology(List<Integer>[] map, int[] builds, int[] arr, Queue<Integer> que, int n, int k, int w) {
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				arr[next]--;
				visit[next] = Math.max(visit[next], visit[now] + builds[next]);
				if(isZero(arr[next])) {
					que.offer(next);
				}
			}
		}
		return visit[w];
	}

}
