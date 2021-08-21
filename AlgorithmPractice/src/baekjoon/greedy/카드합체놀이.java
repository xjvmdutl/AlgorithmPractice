package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드합체놀이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		str = reader.readLine().split(" ");
		long[] arr = new long[n];
		for(int i=0;i<n;++i) {
			arr[i] = Long.parseLong(str[i]);
		}
		System.out.println(solution(arr,n,m));
	}

	private static long solution(long[] arr, int n, int m) {
		long sum = 0;
		for(int i=0;i<m;++i) {
			Arrays.sort(arr);
			long a = arr[0];
			long b = arr[1];
			arr[0] = a+b;
			arr[1] = a+b;
		}
		for(long i : arr)
			sum+=i;
		return sum;
	}

}
