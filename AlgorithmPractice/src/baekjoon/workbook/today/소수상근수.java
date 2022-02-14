package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 소수상근수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		boolean[] sosu = new boolean[n+1];
		for(int i=2;i<=n;++i) {
			for(int j=i+i;j<=n;j+=i) {
				sosu[j] = true;
			}
		}
		OUTER:for(int i=2;i<=n;++i) {
			if(!sosu[i]) {
				Set<Integer> set = new HashSet<>();
				int number = i;
				set.add(i);
				while(number != 1){
					int now = number;
					number = 0;
					while(now > 0) {
						number += Math.pow((now%10), 2);
						now /= 10;
					}
					if(set.contains(number)) {
						continue OUTER;
					}
					set.add(number);
				}
				sb.append(i + "\n");
			}
		}
		return sb.toString();
	}
}
