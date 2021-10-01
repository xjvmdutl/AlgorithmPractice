package baekjoon.sieveofEratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수상근수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		boolean[] sosu = new boolean[n+1];
		sosu[1] = true;
		for(int i=2;i<=n;++i) {
			if(sosu[i])
				continue;
			for(int j=i+i;j<=n;j+=i) {
				sosu[j] = true;
			}
		}
		boolean[] sang = new boolean[n+1];
		for(int i=2;i<=n;++i) {
			if(!sosu[i] && !sang[i]) {	
				int num = i;
				List<Integer> list = new ArrayList<>();
				do{
					list.add(num);
					if(num == 1)
						break;
					int data = 0;
					while(num > 0) {
						data += Math.pow(num%10,2);
						num /= 10;
					}
					num = data;
				}while(!list.contains(num));
				if(num == 1) {
					sb.append(i+"\n");
				}else {
					for(int number : list) {
						if(number <= n)
							sang[number] = true;
					}
				}
			}
		}
		return sb.toString();
	}

}
