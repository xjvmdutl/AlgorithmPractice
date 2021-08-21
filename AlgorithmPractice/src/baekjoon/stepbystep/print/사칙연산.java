package baekjoon.stepbystep.print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사칙연산 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		int a = Integer.parseInt(str.split(" ")[0]);
		int b = Integer.parseInt(str.split(" ")[1]);
		System.out.println(solutiom(a,b));
	}

	private static String solutiom(int a, int b) {
		StringBuilder sb = new StringBuilder();
		sb.append((a+b) + "\n");
		sb.append((a-b) + "\n");
		sb.append((a*b) + "\n");
		sb.append((a/b) + "\n");
		sb.append(a%b);
		return sb.toString();
	}

}
