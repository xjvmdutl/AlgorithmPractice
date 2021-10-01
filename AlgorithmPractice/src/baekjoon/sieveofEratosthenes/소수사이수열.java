package baekjoon.sieveofEratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수사이수열 {
	public static boolean[] sosu;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		int[] arr = new int[t];
		for(int i=0;i<t;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,t));
	}

	private static String solution(int[] arr, int t) {
		StringBuilder sb = new StringBuilder();
		sosu = new boolean[1299710];
		sosu[1] = true;
		for(int i=2;i<=1299709;++i) {
			if(sosu[i])
				continue;
			for(int j=i+i;j<=1299709;j+=i) {
				sosu[j] = true;
			}
		}
		for(int i=0;i<arr.length;++i) {
			int num = arr[i];
			if(!sosu[num]) {
				sb.append(0+"\n");
				continue;
			}
				
			while(sosu[num]) {
				num--;
			}
			int length = 0;
			for(int j=num+1;j<sosu.length;++j) {
				length++;
				if(!sosu[j]) {
					break;
				}
			}
			sb.append(length+"\n");
		}
		
		return sb.toString();
	}

}
