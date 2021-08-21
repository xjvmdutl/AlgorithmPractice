package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사과나무 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		int[] arr = new int[n];
		for(int i =0 ;i<n;++i)
			arr[i] = Integer.parseInt(strs[i]);
		System.out.println(solution(n,arr));
	}

	private static String solution(int n, int[] arr) {
		int sum = 0;
		int twoCount = 0;
		for(int i=0;i<n;++i) {
			sum += arr[i];
			twoCount += arr[i]/2;//2의 갯수
		}
		
		if(sum % 3 ==0 )
			if(twoCount >= sum/3) {
				return "YES";
			}else {
				return "NO";
			}
		else
			return "NO";
	}
}
