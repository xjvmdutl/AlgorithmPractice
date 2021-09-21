package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드합체놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(reader.readLine());
		long[] arr = new long[n];
		for(int i=0;i<n;++i) {
			arr[i] = Long.parseLong(tokens.nextToken());
		}
		System.out.println(solution(arr,n,m));
	}

	private static long solution(long[] arr, int n, int m) {
		Queue<Long> pq = new PriorityQueue<>();
		for(int i=0;i<n;++i) {
			pq.offer(arr[i]);
		}
		while(m-- > 0) {
			long n1 = pq.poll();
			long n2 = pq.poll();
			pq.offer(n1+n2);
			pq.offer(n1+n2);
		}
		long sum = 0;
		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		return sum;
	}

}
