package baekjoon.stepbystep.math02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ∞ÒµÂπŸ»Â¿«√ﬂ√¯ {
	public static boolean[] prime;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		int max = 0;
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
			max = Math.max(max, arr[i]);
		}
		System.out.println(solution(n,arr,max));
	}

	private static String solution(int n, int[] arr, int max) {
		prime = new boolean[max + 1];
		StringBuilder sb= new StringBuilder();
		get_prime();
		for(int i=0;i<arr.length;++i) {
			int data = arr[i];
			int p = data/2;
			int q = data/2;
			while(true) {
				if(!prime[p] && ! prime[q]) {
					sb.append(p + " " + q + "\n");
					break;
				}
				p--;
				q++;
			}
			
		}
		
		return sb.toString();
	}
	public static void get_prime() {
		// true = º“ºˆæ∆¥‘ , false = º“ºˆ 
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}
