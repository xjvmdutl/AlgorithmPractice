package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class º°Âï±â9 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;++i) {
			for(int j=1;j<i;++j) {
				sb.append(" ");
			}
			for(int j=(n-i+1)*2;j>1;--j) {
				sb.append("*");
			}
			sb.append("\n");
		}
		for(int i=n-1;i>0;--i) {
			for(int j=1;j<i;++j) {
				sb.append(" ");
			}
			for(int j=(n-i+1)*2;j>1;--j) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}

}
