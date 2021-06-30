package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¡÷¿Øº“ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		long[] arr = new long[n-1];
		String[] str = reader.readLine().split(" ");
		for(int i=0;i<str.length;++i) {
			arr[i] = Long.parseLong(str[i]);
		}
		long[] price = new long[n];
		str = reader.readLine().split(" ");
		for(int i=0;i<str.length-1;++i) {
			price[i] = Long.parseLong(str[i]);
		}
		System.out.println(solution(arr,price,n));
	}
	private static long solution(long[] arr, long[] price, int n) {
		long sum = 0;
		long minCost = price[0];
		for(int i=0;i<n-1;++i) {
			if(price[i] < minCost)
				minCost = price[i];
			sum += minCost * arr[i];
		}
		return sum;
	}
	
}
