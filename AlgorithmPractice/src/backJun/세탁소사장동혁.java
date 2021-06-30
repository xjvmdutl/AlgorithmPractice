package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¼¼Å¹¼Ò»çÀåµ¿Çõ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int c = Integer.parseInt(reader.readLine());
			System.out.println(solution(c));
		}
	}

	private static String solution(int c) {
		
		StringBuilder sb = new StringBuilder();
		int dollar = 25;
		sb.append(c/dollar + " ");
		c%=dollar;
		dollar = 10;
		sb.append(c/dollar + " ");
		c%=dollar;
		dollar = 5;
		sb.append(c/dollar + " ");
		c%=dollar;
		dollar = 1;
		sb.append(c/dollar);
		c%=dollar;
		return sb.toString();
	}

}
