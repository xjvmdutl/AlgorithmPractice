package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ã¶·Î {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken());
			int e = Integer.parseInt(tokens.nextToken());
			
			arr[i][0] = Math.min(s, e);
			arr[i][1] = Math.max(s, e);
		}
		int d = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr,n,d));
	}

	private static int solution(int[][] arr, int n, int d) {
		int answer = 0;
		Arrays.sort(arr,(o1,o2)->{
			if(o1[1] == o2[1])
				return o1[0] -o2[0];
			return o1[1] - o2[1];
		});
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<arr.length;++i) {
			pq.offer(arr[i][0]);
			while(!pq.isEmpty() && pq.peek() < arr[i][1] - d ) {
				pq.poll();
			}
			answer = Math.max(answer, pq.size());
		}
		return answer;
	}

}
