package baekjoon.stepbystep.iftest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class À±³â {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(reader.readLine());
		System.out.println(solution(year));
		
	}

	private static int solution(int year) {
		int answer = 0;
		if(year % 4 == 0
				&& (year % 100 != 0
				|| year % 400 == 0)) {
			answer = 1;
		}
		
		
		return answer;
	}

}
