package baekjoon.stepbystep.print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ³ª¸ÓÁö {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		int a = Integer.parseInt(str.split(" ")[0]);
		int b = Integer.parseInt(str.split(" ")[1]);
		int c = Integer.parseInt(str.split(" ")[2]);
		System.out.println(solution(a,b,c));
	}

	private static String solution(int a, int b, int c) {
		StringBuilder sb = new StringBuilder();
		int num = (a+b)%c;
		sb.append(num + "\n");
		num = ((a%c)+(b%c))%c;
		sb.append(num + "\n");
		num = (a*b)%c;
		sb.append(num + "\n");
		num = ((a%c)*(b%c))%c;
		sb.append(num);
		return sb.toString();
	}

}
