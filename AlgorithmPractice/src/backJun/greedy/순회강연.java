package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 순회강연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			String[] strs = reader.readLine().split(" ");
			arr[i][0] = Integer.parseInt(strs[0]);
			arr[i][1] = Integer.parseInt(strs[1]);
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		Arrays.sort(arr,(o1,o2)->{
			if(o1[1] == o2[1])
				return o2[0] - o1[0];
			return o1[1] - o2[1];
		});
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i=0;i<arr.length;++i) {
			que.offer(arr[i][0]);
			while(que.size() > arr[i][1]) {
				que.poll();
			}
		}
		while(!que.isEmpty()) {
			answer += que.poll();
		}
		return answer;
	}

}
