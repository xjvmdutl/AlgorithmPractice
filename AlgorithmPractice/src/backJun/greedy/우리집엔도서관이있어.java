package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 우리집엔도서관이있어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr= new int[n];
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int start = 1;
		int sum = 0;
		if(n <= 1) {
			return 0;
		}
		if(arr[0] > 1) {
			sum += arr[0] - 1;
			start = arr[0];
		}
		
		for(int i = 1; i < n; i++) {
			if(start + 1 < arr[i]) {
				sum += arr[i] - start;
				start = arr[i];
			}
			
			if(start + 1 == arr[i]) {
				start = arr[i];
			}
		}
		
		return sum;
	}
}
