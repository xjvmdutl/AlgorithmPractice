package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->o2-o1);
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				pq.offer(arr[i][j]);
			}	
		}
		for(int i=0;i<n-1;++i) {
			pq.poll();
		}
		
		return pq.poll();
	}

}
