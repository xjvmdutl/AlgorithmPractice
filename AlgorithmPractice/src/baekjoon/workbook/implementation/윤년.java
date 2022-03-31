package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class À±³â {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(Integer.parseInt(reader.readLine())));
	}

	private static int solution(int year) {
		boolean answer = false;
		if(year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)) {
			answer = true;
		}
		return answer ? 1 : 0;
	}

}
