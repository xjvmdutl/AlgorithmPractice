package backJun.stepBystep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수5 {
	public static int[] fibo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		fibo = new int[n+1];
		if(n>=0) {
			fibo[0] = 0;
		}
		if(n>=1) {
			fibo[1] = 1;
		}
		fibonacci(n);
		return fibo[n];
	}

	private static int fibonacci(int n) {
		
		
		if(n == 0 )
			return fibo[0];
		if(n == 1)
			return fibo[1];
		if(fibo[n] == 0) {
			fibo[n] = fibonacci(n-1) + fibonacci(n-2);
		}
		return fibo[n];
		
		
		
	}

}
