package baekjoon.stepbystep.math02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 택시기하학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(reader.readLine());
		System.out.println(solution(r));
	}

	private static String solution(int r) {
		StringBuilder sb = new StringBuilder();
		double d1 = Math.PI * r * r;
		sb.append(String.format("%.5f", d1) + "\n");
		double d2 = 2 * r * r;
		sb.append(String.format("%.5f", d2));
		return sb.toString();
	}

}
