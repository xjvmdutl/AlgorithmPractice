package baekjoon.stepbystep.math02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 소인수분해 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		while(n > 1) {
			for(int i=2;i<=n;++i) {
				if(n%i==0) {
					list.add(i);
					n/=i;
					break;
				}
			}
		}
		Collections.sort(list);
		for(int data : list)
			sb.append(data + "\n");
		return sb.toString();
	}

}
