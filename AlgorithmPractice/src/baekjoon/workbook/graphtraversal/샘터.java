package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class ป๙ลอ {
	private static boolean stop;
	private static int stopCount;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] map = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			map[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map, n, k));
	}

	private static long solution(int[] map, int n, int k) {
		Queue<Integer> que = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		init(map, n, que, set);
		return bfs(que, set, n, k);
	}

	private static void init(int[] map, int n, Queue<Integer> que, Set<Integer> set) {
		for(int i=0;i < n; ++i) {
			que.offer(map[i]);
			set.add(map[i]);
		}
	}
	
	private static long bfs(Queue<Integer> que, Set<Integer> set, int n, int k) {
		long answer = 0;
		stop = false;
		stopCount = k;
		int distance = 1;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0;i<size;++i) {
				int now = que.poll();
				answer += contain(set, que, now + 1, distance);
				if(stop) {
					return answer;
				}
				answer += contain(set, que, now - 1, distance);
				if(stop) {
					return answer;
				}
			}
			distance++;
		}
		return answer;
	}

	private static int contain(Set<Integer> set, Queue<Integer> que, int number, int distance) {
		if(!set.contains(number)) {
			set.add(number);
			que.offer(number);
			if(--stopCount <= 0) {
				stop = true;
			}
			return distance;
		}
		return 0;
	}



}
