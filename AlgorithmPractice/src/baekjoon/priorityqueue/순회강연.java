package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 순회강연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		Queue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(arr, (o1,o2)->{
			if(o1[1] == o2[1] )
				return o2[0] - o1[0];
			return o1[1]-o2[1];
		});
		for(int i=0;i<arr.length;++i) {
			if(pq.size() >= arr[i][1] && pq.peek() < arr[i][0]) {
				pq.poll();
				pq.offer(arr[i][0]);
			}else if(pq.size() < arr[i][1]){
				pq.offer(arr[i][0]);
			}
		}
		while(!pq.isEmpty()) {
			answer+=pq.poll();
		}
		return answer;
	}

}
