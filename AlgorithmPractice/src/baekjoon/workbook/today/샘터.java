package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class ป๙ลอ {
	public static Set<Integer> set;
	public static long answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr, n, k));
	}

	private static long solution(int[] arr, int n, int k) {
		answer = 0;
		set = new HashSet<>();
		
		bfs(arr,n,k);
		return answer;
	}

	private static void bfs(int[] arr, int n, int k) {
		Queue<Integer> que = new LinkedList<>();
		init(que, arr, n);
		int dis = 1;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0;i<size;++i) {
				int now = que.poll();
				int right = now + 1;
				int left = now - 1;
				if(!set.contains(right)) {
					que.offer(right);
					answer += dis;
					set.add(right);
					if(--k <= 0) {
						return;
					}
				}
				if(!set.contains(left)) {
					que.offer(left);
					answer += dis;
					set.add(left);
					if(--k <= 0) {
						return;
					}
				}
			}
			dis++;
		}
	}

	private static void init(Queue<Integer> que, int[] arr, int n) {
		for(int i=0;i<n;++i) {
			que.offer(arr[i]);
			set.add(arr[i]);
		}
	}

}
