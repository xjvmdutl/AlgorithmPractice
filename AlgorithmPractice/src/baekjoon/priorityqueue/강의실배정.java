package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr));
	}

	private static int solution(int[][] arr) {
		int answer = 0;
		Arrays.sort(arr,(o1,o2)->{
			if(o1[0] == o2[0])
				return o1[1] - o2[1];
			return o1[0] - o2[0];
		});
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<arr.length;++i) {
			int start = arr[i][0];
			int end = arr[i][1];
			while(!pq.isEmpty()) {
				int num = pq.poll();
				if(start < num) {
					pq.offer(num);
					break;
				}
			}
			pq.offer(end);
			answer = Math.max(answer, pq.size());
		}
		return answer;
	}

}
