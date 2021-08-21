package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 카드정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr,int n) {
		if(n == 1)
			return 0;
		Queue<Integer> queue = new PriorityQueue<>();
		for(int i=0;i<n;++i)
			queue.offer(arr[i]);
		int answer = 0;
		while(!queue.isEmpty()) {
			int data = queue.poll()+ queue.poll();
			answer += data;
			if(!queue.isEmpty()) {
				queue.offer(data);
			}
		}
		return answer;
	}

}
