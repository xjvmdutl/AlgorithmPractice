package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연료채우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int l = Integer.parseInt(tokens.nextToken());
		int p = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr,n,l,p));
	}

	private static int solution(int[][] arr, int n, int l, int p) {
		int answer = 0;
		int now = p;
		Arrays.sort(arr,(o1,o2)->{
			if(o1[0] == o2[0]) {
				return o2[1] - o1[1];
			}
			return o1[0] - o2[0];
		});
		Queue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
		for(int i=0;i<n;++i) {
			while(!pq.isEmpty() && now < arr[i][0]) {
				now += pq.poll();
				answer++;
			}
			if(now < arr[i][0]) {
				return -1;
			}
			pq.offer(arr[i][1]);
		}
		if(now >= l) {
			return answer;
		}else {
			while(!pq.isEmpty()) {
				now += pq.poll();
				answer++;
				if(now >= p) {
					break;
				}
			}
			return now >= l ? answer : -1;
		}
	}

}
