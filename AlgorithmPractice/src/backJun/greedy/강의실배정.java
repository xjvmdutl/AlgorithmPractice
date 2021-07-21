package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 강의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			String[] strs = reader.readLine().split(" ");
			arr[i][0] = Integer.parseInt(strs[0]);
			arr[i][1] = Integer.parseInt(strs[1]);
		}
		System.out.println(solution(arr));
	}

	private static int solution(int[][] arr) {
		Arrays.sort(arr,(o1,o2)->{
			if(o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		que.offer(arr[0][1]);
		for(int i=1;i<arr.length;++i) {
			if(que.peek() <= arr[i][0]) {
				que.poll();
				que.offer(arr[i][1]);
			}else {
				que.offer(arr[i][1]);
			}
		}
		return que.size();
	}

}
