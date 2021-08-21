package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 국회의원선거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		int dasom = arr[0];
		if(n==1)
			return answer;
		while(true) {
			Arrays.sort(arr,1,arr.length);
			if(dasom > arr[arr.length-1]) {
				break;
			}
			arr[arr.length-1] -= 1;
			dasom += 1;
			answer++;
		}
		return answer;
	}

}
