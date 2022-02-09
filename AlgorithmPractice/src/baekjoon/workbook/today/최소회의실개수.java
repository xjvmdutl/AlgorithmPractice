package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최소회의실개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		Arrays.sort(arr, (o1, o2)->{
			if(o1[0] == o2[0])
				return o1[1] - o2[1];
			return o1[0] - o2[0];
		});
		Queue<Integer> que = new PriorityQueue<>();
		for(int i=0;i<n;++i) {
			while(!que.isEmpty() && que.peek() <= arr[i][0]) {
				que.poll();
			}
			que.offer(arr[i][1]);
			answer = Math.max(que.size(), answer);		
		}
		return answer;
	}

}
