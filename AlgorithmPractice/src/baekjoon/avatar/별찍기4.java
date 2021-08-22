package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class º°Âï±â4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=n;i>0;--i) {
			for(int j=n;j>i;--j) {
				sb.append(" ");
			}
			for(int j=i;j>0;--j) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}

}
