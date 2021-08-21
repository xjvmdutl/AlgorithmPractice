package baekjoon.stepbystep.fortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ±¸±¸´Ü {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=9;++i) {
			sb.append(n + " * " + i + " = " + (n*i) + "\n");
		}
		return sb.toString();
	}

}
