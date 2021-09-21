package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 카드정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<n;++i) {
			pq.offer(arr[i]);
		}
		int sum = 0;
		while(pq.size() >= 2) {
			int n1 = pq.poll();
			int n2 = pq.poll();
			pq.offer(n1+n2);
			sum += n1+n2;
		}
		
		
		return sum;
	}

}
