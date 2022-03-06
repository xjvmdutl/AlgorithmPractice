package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 칸토어집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str = reader.readLine()) != null) {
			int n = Integer.parseInt(str);
			System.out.println(solution(n));
		}
	}

	private static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Math.pow(3, n);++i) {
			sb.append("-");
		}
		Kantore(sb, 0, n);
		return sb.toString();
	}

	private static void Kantore(StringBuilder sb, int start, int n) {
		if(n == 0)
			return;
		int length = (int) Math.pow(3, n-1);
		for(int i=start+length;i < start+(2*length);++i) {
			sb.setCharAt(i, ' ');
		}
		Kantore(sb, start, n-1);
		Kantore(sb, start+2*length, n-1);
	}

}
