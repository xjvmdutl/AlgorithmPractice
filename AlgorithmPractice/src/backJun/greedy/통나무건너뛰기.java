package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 통나무건너뛰기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i =0;i<t;++i) {
			int n = Integer.parseInt(reader.readLine());
			int[] arr = new int[n];
			String[] str = reader.readLine().split(" ");
			for(int j =0;j<n;++j)
				arr[j] = Integer.parseInt(str[j]);
			System.out.println(solution(arr,n));
		}
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		Arrays.sort(arr);
		Queue<Integer> upSortQ = new PriorityQueue<>();
		Queue<Integer> downSortQ = new PriorityQueue<>((o1,o2)->{
			return o2-o1;
		});
		for(int i =0;i<arr.length;++i) {
			if(i%2 == 0) {
				upSortQ.offer(arr[i]);
			}else {
				downSortQ.offer(arr[i]);
			}
		}
		int startN = upSortQ.peek();
		int data = upSortQ.poll();
		while(!upSortQ.isEmpty()) {
			int tmp = upSortQ.poll();
			answer = Math.max(Math.abs(tmp-data), answer);
			data = tmp;
		}
		while(!downSortQ.isEmpty()) {
			int tmp = downSortQ.poll();
			answer = Math.max(Math.abs(data-tmp), answer);
			data = tmp;
		}
		answer = Math.max(Math.abs(data-startN), answer);
		return answer;
	}

}
