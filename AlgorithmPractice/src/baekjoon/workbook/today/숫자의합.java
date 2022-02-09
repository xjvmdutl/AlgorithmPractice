package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String str = reader.readLine();
		System.out.println(solution(str,n));
	}

	private static int solution(String str, int n) {
		int sum = 0;
		for(int i=0;i<n;++i)
			sum += str.charAt(i) - '0';
		return sum;
	}

}
