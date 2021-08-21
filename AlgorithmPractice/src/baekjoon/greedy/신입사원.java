package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 신입사원 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			int n = Integer.parseInt(reader.readLine());
			int[] arr = new int[n];
			for(int j=0;j<n;++j) {
				String[] strs = reader.readLine().split(" ");
				arr[Integer.parseInt(strs[0])-1] = Integer.parseInt(strs[1]);
			}
			System.out.println(solution(arr));
		}
		
	}

	private static int solution(int[] arr) {
		int answer = 1;
		int score = arr[0];
		for(int i=1;i<arr.length;++i) {
			if(score > arr[i]) {
				score = arr[i];
				answer++;
			}
		}
		
		return answer;
	}

}
