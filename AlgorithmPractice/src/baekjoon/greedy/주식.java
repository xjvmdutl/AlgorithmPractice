package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 주식 {
	//거꾸로 생각
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i = 0;i<t;++i) {
			int n = Integer.parseInt(reader.readLine());
			String[] str = reader.readLine().split(" ");
			int[] arr = new int[n];
			for(int j=0;j<n;++j)
				arr[j] = Integer.parseInt(str[j]);
			System.out.println(solution(n,arr));
		}
	}

	private static long solution(int n, int[] arr) {
		long answer = 0;
		int max = 0;
		for(int i=n-1;i>=0;--i) {
			if(arr[i] > max) {
				max = arr[i];
			}else {
				answer += (max - arr[i]);
			}
		}
		
		return answer;
	}

}
