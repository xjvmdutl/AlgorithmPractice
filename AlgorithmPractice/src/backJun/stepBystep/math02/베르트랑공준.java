package backJun.stepBystep.math02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ����Ʈ������ {
	public static boolean[] prime;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while(true) {
			String str = reader.readLine();
			int n = Integer.parseInt(str);
			if(n == 0)
				break;
			max = Math.max(max, n);
			list.add(n);
		}
		prime = new boolean[(max * 2) + 1];
		get_prime();
		for(int i =0;i<list.size();++i) {
			int data = list.get(i);
			int count = 0;
			for(int j = data+1; j <= 2*data; j++) {
				if(!prime[j]) count++;
			}
			System.out.println(count);
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
