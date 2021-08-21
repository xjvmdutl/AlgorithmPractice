package baekjoon.stepbystep.math02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �Ҽ����ϱ� {

	public static boolean[] prime;
	public static void main(String[] args) throws IOException {
 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int m = Integer.parseInt(strs[0]);
		int n = Integer.parseInt(strs[1]);
		
		prime = new boolean[n + 1];
		get_prime();
				
		for(int i = m; i <= n; i++) {
			// false = �Ҽ� 
			if(!prime[i]) System.out.println(i);
		}
	}
 
 
	// �����佺�׳׽��� ü �˰���
	public static void get_prime() {
		// true = �Ҽ��ƴ� , false = �Ҽ� 
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}

}
