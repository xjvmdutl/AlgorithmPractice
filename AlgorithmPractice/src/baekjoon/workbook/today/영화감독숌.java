package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class ¿µÈ­°¨µ¶¼ò {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {	
		int answer = 1;
		int num = 666;
		while(answer < n) {
			num++;
			if(String.valueOf(num).contains("666")) {
				answer++;
			}
		}
		
		return String.valueOf(num);
	}

}
