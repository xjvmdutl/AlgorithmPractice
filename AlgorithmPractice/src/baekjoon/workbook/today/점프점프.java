package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Jump implements Comparable<Jump>{
	int x;
	int count;
	public Jump(int x, int count) {
		this.x = x;
		this.count = count;
	}
	@Override
	public int compareTo(Jump o) {
		return this.count - o.count;
	}
}
public class 점프점프 {
	public static int answer;
	public static int[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[] arr, int n) {
		answer = -1;
		visit = new int[n];
		Arrays.fill(visit, Integer.MAX_VALUE);
		bfs(arr, n);
		return answer;
	}

	private static void bfs(int[] arr, int n) {
		Queue<Jump> que = new PriorityQueue<>();
		que.offer(new Jump(0, 0));
		while(!que.isEmpty()) {
			Jump j = que.poll();
			if(j.x == n-1) {
				answer = j.count;
				return;
			}
			if(arr[j.x] == 0)
				continue;
			for(int i=1;i<=arr[j.x];++i) {
				int nx = j.x + i;
				if(nx < n && j.count + 1 < visit[nx]) {
					visit[nx] = j.count+1;
					que.offer(new Jump(nx, j.count+1));
				}
			}
		}
		
	}

}
