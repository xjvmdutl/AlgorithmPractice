package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치 {
	public static long[] fibo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		fn_init();
		for(int i = 0 ;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
			System.out.println(solution(n,arr[i]));
		}
		
	}
	private static void fn_init() {
		fibo = new long[45];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i = 2 ;i<fibo.length;++i)
			fibo[i] = fibo[i-2] + fibo[i-1];
	}
	private static String solution(int n, int data) {
		boolean[] arr = new boolean[45];
		for(int i = fibo.length-1;i>=0;--i) {
			if(data - fibo[i] >= 0) {
				data -= fibo[i];
				arr[i] = true;
				if(data == 0)
					break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0 ;i<arr.length;++i)
			if(arr[i])
				sb.append(fibo[i] + " ");
		return sb.delete(sb.length()-1, sb.length()).toString();
	}

}
