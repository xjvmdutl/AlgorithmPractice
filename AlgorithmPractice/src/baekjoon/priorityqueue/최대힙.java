package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class √÷¥Î»¸ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(n,arr));
	}

	private static String solution(int n, int[] arr) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			return o2-o1;
		});
		for(int i=0;i<n;++i) {
			if(arr[i] == 0) {
				if(pq.isEmpty()) {
					sb.append(0+"\n");
				}else {
					sb.append(pq.poll()+"\n");
				}
			}else {
				pq.offer(arr[i]);
			}
		}
		return sb.toString();
	}

}
