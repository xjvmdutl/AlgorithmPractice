package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class ¼ö¹­±â {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		Queue<Integer> plusList = new PriorityQueue<>((o1,o2)->o2-o1);
		Queue<Integer> minusList = new PriorityQueue<>((o1,o2)->o1-o2);
		for(int i=0;i<n;++i) {
			if(arr[i] > 0) {
				plusList.offer(arr[i]);
			}else {
				minusList.offer(arr[i]);
			}
		}
		int sum = 0;
		while(plusList.size() >= 2) {
			int a = plusList.poll();
			int b = plusList.poll();
			if(a == 1 || b == 1) {
				sum += a+b;
			}else {
				sum += a * b;
			}
		}
		
		while(minusList.size() >= 2) {
			int a = minusList.poll();
			int b = minusList.poll();
			sum += a * b;
		}
		
		if(!minusList.isEmpty()) {
			sum += minusList.poll();
			
		}
		if(!plusList.isEmpty()) {
			sum += plusList.poll();
		}
		return sum;
	}

}
