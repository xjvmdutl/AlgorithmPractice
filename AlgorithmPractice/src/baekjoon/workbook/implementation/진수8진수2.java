package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 진수8진수2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(reader.readLine()));
	}

	private static String solution(String num) {
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toBinaryString(num.charAt(0)-'0'));
		for(int i=1;i<num.length();++i) {
			StringBuilder now = new StringBuilder(Integer.toBinaryString(num.charAt(i)-'0'));
			while (now.length() < 3) {
				now.insert(0, "0");
			}
			sb.append(now.toString());
		}
		return sb.toString();
	}

}
