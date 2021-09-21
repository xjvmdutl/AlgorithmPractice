package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 중앙값구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int m = Integer.parseInt(reader.readLine());
			int[] arr = new int[m];
			int num = m/10;
			int idx = 1;
			while(num-- >= 0) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				for(int i=(idx-1)*10;i<(idx*10 > m ? m : idx*10);++i) {
					arr[i] = Integer.parseInt(tokens.nextToken());
				}
				idx++;
			}
			System.out.println(solution(arr,m));
		}
	}

	private static String solution(int[] arr, int m) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> minHeap = new PriorityQueue<>();
		Queue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
		sb.append((m+1)/2 + "\n");
		for(int i=0;i<arr.length;++i) {
			if(maxHeap.size() == minHeap.size()) {
				maxHeap.offer(arr[i]);
			}else {
				minHeap.offer(arr[i]);
			}
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(minHeap.peek() < maxHeap.peek()) {
					int tmp = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(tmp);
				}
			}
			if(i%2 == 0) {
				sb.append(maxHeap.peek() + " ");
			}
			
		}
		
		return sb.toString();
	}

}
