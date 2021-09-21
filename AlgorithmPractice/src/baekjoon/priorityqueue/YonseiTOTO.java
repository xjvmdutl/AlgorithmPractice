package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class YonseiTOTO {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int p = Integer.parseInt(tokens.nextToken());
			int l = Integer.parseInt(tokens.nextToken());
			int[] arr = new int[p];
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<p;++j) {
				arr[j] = Integer.parseInt(tokens.nextToken());
			}
			pq.offer(solution(arr,p,l));
		}
		int answer = 0;
		while(!pq.isEmpty()) {
			if(m - pq.peek() >= 0) {
				answer++;
				m -= pq.poll();
			}else {
				break;
			}
		}
		System.out.println(answer);
	}

	private static int solution(int[] arr, int p, int l) {
		if(p < l)
			return 1;
		int[] reverse = Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		int data = reverse[l-1];
		return data;
	}

}
