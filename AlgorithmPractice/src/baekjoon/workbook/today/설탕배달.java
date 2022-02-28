package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¼³ÅÁ¹è´Ş {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		for(int i=n/5;i>=0;--i) {
			int result = n - i*5;
			if(result % 3 == 0)
				return (result / 3) + i;
		}
		return -1;
	}

}
