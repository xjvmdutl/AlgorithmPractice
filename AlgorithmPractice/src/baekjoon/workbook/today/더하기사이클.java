package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기사이클 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 0;
		int first = n;
		do {
			int n1 = n / 10;
			int n2 = n % 10;
			int sum = n1 + n2;
			n = (n2 * 10) + (sum % 10);
			answer++;
		}while(first != n);
		return answer;
	}

}
