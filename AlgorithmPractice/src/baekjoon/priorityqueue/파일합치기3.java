package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파일합치기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			int k = Integer.parseInt(reader.readLine());
			long[] arr = new long[k];
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<k;++j) {
				arr[j] = Long.parseLong(tokens.nextToken());
			}
			System.out.println(solution(arr,k));
		}
	}

	private static long solution(long[] arr, int k) {
		long answer = 0;
		Queue<Long> pq = new PriorityQueue<>();
		for(int i=0;i<arr.length;++i) {
			pq.offer(arr[i]);
		}
		
		while(pq.size() >= 2) {
			long n1 = pq.poll();
			long n2 = pq.poll();
			pq.offer(n1 + n2);
			answer += n1+n2;
		}
		return answer;
	}

}
