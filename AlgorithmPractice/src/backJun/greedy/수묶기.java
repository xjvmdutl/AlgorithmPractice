package backJun.greedy;

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

	private static int solution(int[] arr,int n) {
		int answer = 0;
		if(n == 1)
			return arr[0];
		PriorityQueue<Integer> que1 = new PriorityQueue<>((o1,o2)->o2-o1);
		PriorityQueue<Integer> que2 = new PriorityQueue<>((o1,o2)->o1-o2);
		for(int i=0;i<arr.length;++i) {
			if(arr[i] > 0)
				que1.offer(arr[i]);
			else
				que2.offer(arr[i]);
		}
		while(que1.size() >= 2) {
			int data1 = que1.poll();
			int data2 = que1.poll();
			if(data1 * data2 < data1 + data2) {
				answer += data1 + data2; 
				break;
			}
			answer += data1 * data2;
		}
		while(!que1.isEmpty())
			que2.offer(que1.poll());
		
		while(que2.size() >= 2) {
			int data1 = que2.poll();
			int data2 = que2.poll();
			if(data1 * data2 < data1 + data2) {
				answer += data1 + data2; 
				break;
			}
			answer += data1 * data2;
		}
		while(!que2.isEmpty()) {
			int data = que2.poll();
			answer += data;
		}
		return answer;
	}
}
