package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APlusB2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());
		System.out.println(solution(a,b));
	}

	private static int solution(int a, int b) {
		return a+b;
	}
}
