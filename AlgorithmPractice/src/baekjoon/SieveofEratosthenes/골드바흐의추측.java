package baekjoon.SieveofEratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ∞ÒµÂπŸ»Â¿«√ﬂ√¯ {
	public static boolean[] sosu;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		while(true) {
			int num = Integer.parseInt(reader.readLine());
			if(num == 0)
				break;
			list.add(num);
		}
		System.out.println(solution(list));
	}

	private static String solution(List<Integer> list) {
		StringBuilder sb = new StringBuilder();
		sosu = new boolean[1000001];
		sosu[1] = true;
		for(int i=2;i<=1000000;++i) {
			if(sosu[i])
				continue;
			for(int j=i+i;j<=1000000;j+=i) {
				sosu[j] = true;
			}
		}
		for(int i=0;i<list.size();++i) {
			int num = list.get(i);
			boolean flag = true;
			for(int j=2;j<=num/2;++j) {
				if(!sosu[j] && !sosu[num-j]) {
					flag = false;
					sb.append(num + " = " + j + " + " + (num-j) + "\n");
					break;
				}
			}
			if(flag) {
				sb.append("Goldbach's conjecture is wrong" + "\n");
			}
		}
		
		return sb.toString();
	}

}
