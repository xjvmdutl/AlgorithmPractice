package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 감소하는수 {
	public static List<Long> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static long solution(int n) {
		list = new ArrayList<>();
		if(n <= 10)
			return n;
		else if(n > 1022)
			return -1;
		else {
			for(int i=0;i<10;++i) {
				cal(i,1);
			}
			Collections.sort(list);
			return list.get(n);
		}
	}

	private static void cal(long num, int depth) {
		if(depth > 10)
			return;
		list.add(num);
		for(int i=0;i<num%10;++i) {
			cal((num*10)+i, depth+1);
		}
	}

}
