package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알바생강호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(n,arr));
	}

	private static long solution(int n, int[] arr) {
		long answer = 0;
		int[] reverse = Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		for(int i=0;i<reverse.length;++i) {
			int tip = reverse[i] - i;
			if(tip < 1)
				continue;
			answer+=tip;
		}
		return answer;
	}

}
