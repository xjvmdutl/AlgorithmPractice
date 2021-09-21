package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class º¸¼®µµµÏ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		int[] bags = new int[k];
		for(int i=0;i<k;++i) {
			bags[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,bags,n,k));
	}

	private static long solution(int[][] arr, int[] bags, int n, int k) {
		long answer = 0;
		Arrays.sort(arr,(o1,o2)->{
			if(o1[0] == o2[0])
				return o2[1] - o1[1];
			return o1[0] - o2[0];
		});
		Queue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
		Arrays.sort(bags);
		int idx = 0;
		for(int i=0;i<k;++i) {
			int bag = bags[i];
			while(idx < arr.length && arr[idx][0] <= bag) {
				pq.offer(arr[idx++][1]);
			}
			if(!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		
		return answer;
	}

}
