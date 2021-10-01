package baekjoon.sieveofEratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 베르트랑공준 {
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
		sosu = new boolean[123456*2+1];
		sosu[1] = true;
		for(int i =2; i <= 123456*2;++i) {
			if(sosu[i]) {
				continue;
			}
			for(int j=i+i;j<=123456*2;j+=i) {
				sosu[j] = true;
			}
		}
		for(int i=0;i<list.size();++i) {
			int start = list.get(i);
			int end = list.get(i)*2;
			int count = 0;
			for(int j=start+1;j<=end;++j) {
				if(!sosu[j])
					count++;
			}
			sb.append(count+"\n");
		}
		return sb.delete(sb.length()-1, sb.length()).toString();
	}

}
