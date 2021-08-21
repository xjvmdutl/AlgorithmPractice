package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ÄÅ¶ó¸é {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			String[] strs = reader.readLine().split(" ");
			arr[i][0] = Integer.parseInt(strs[0]);
			arr[i][1] = Integer.parseInt(strs[1]);
			
		}
		System.out.println(solution(arr,n));
	}

	private static long solution(int[][] arr,int n) {

		long answer = 0;
		Arrays.sort(arr,(o1,o2)->{
			if(o1[0] == o2[0])
				return o2[1] - o1[1];
			return o1[0] - o2[0];
		});
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<arr.length;++i) {
			pq.offer(arr[i][1]);
			while(pq.size() > arr[i][0]) {
				pq.poll();
			}	
		}
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		return answer;
	}

}
