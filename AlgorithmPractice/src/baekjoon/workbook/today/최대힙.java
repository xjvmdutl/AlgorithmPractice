package baekjoon.workbook.today;

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
		System.out.println(solution(arr, n));
	}

	private static String solution(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
		for(int i=0;i<n;++i) {
			int x = arr[i];
			if(x > 0) {
				pq.offer(x);
			}else if(x <= 0) {
				if(pq.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(pq.poll() + "\n");
				}
			}
		}
		return sb.toString();
	}

}
