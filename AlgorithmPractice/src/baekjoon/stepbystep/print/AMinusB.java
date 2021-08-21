package baekjoon.stepbystep.print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AMinusB {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);
		System.out.println(solution(a,b));
	}

	private static int solution(int a, int b) {

		
		return a-b;
	}

}
