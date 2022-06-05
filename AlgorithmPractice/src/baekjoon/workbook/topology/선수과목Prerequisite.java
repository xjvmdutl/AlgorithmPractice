package baekjoon.workbook.topology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 선수과목Prerequisite {
	private static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		List<Integer>[] map = getMap(n);
		arr = new int[n];
		for(int i=0; i< m;++i) {
			tokens = new StringTokenizer(reader.readLine());	
			int A = Integer.parseInt(tokens.nextToken()) - 1;
			int B = Integer.parseInt(tokens.nextToken()) - 1;
			map[A].add(B);
			arr[B]++;
		}
		System.out.println(solution(map, n));
	}

	private static String solution(List<Integer>[] map, int n) {
		int[] result = topology(map, n);
		return getResult(result, n);
	}

	private static int[] topology(List<Integer>[] map, int n) {
		int[] result = new int[n];
		Queue<Integer> que = new LinkedList<>();
		for(int i=0; i<n;++i) {
			if (arr[i] == 0) {
				result[i] = 1;
				que.offer(i);
			}
		}
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				arr[next]--;
				if(arr[next] == 0) {
					result[next] = result[now] + 1;
					que.offer(next);
				}
			}
		}
		return result;
	}
	
	private static String getResult(int[] result, int n) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<n;++i) {
			answer.append(result[i] + " ");
		}
		return answer.toString();
	}


	private static List<Integer>[] getMap(int n) {
		List<Integer>[] result = new ArrayList[n];
		for(int i=0;i<n;++i) {
			result[i] = new ArrayList<>();
		}
		return result;
	}

}
