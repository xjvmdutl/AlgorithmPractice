package baekjoon.stepbystep.whiletest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APlusB5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			if(a == 0 && b == 0)
				break;
			System.out.println(solution(a,b));
			
		}
	}

	private static int solution(int a, int b) {
		return a+b;
	}

}
