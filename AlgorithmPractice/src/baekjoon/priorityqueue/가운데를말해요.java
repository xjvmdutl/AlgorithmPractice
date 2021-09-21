package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 가운데를말해요 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
		
	}

	private static String solution(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> minHeap = new PriorityQueue<>();
		Queue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
		for(int i=0;i<arr.length;++i) {
			if(minHeap.size() == maxHeap.size()) {
				maxHeap.offer(arr[i]);
			}else {
				minHeap.offer(arr[i]);
			}
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(minHeap.peek() < maxHeap.peek()) {
					int tmp = maxHeap.poll();
					maxHeap.offer(minHeap.poll());
					minHeap.offer(tmp);
				}
			}
			sb.append(maxHeap.peek()+"\n");
		}
		return sb.toString();
	}

}
