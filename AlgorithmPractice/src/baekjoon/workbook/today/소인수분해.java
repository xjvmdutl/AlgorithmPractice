package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소인수분해 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		if(n == 1)
			return "";
		int num = 2;
		while(num < n) {
			if(n % num == 0) {
				n /= num;
				sb.append(num + "\n");
				num = 2;
			}else {
				num++;
			}
		}
		sb.append(num);
		return sb.toString();
	}

}
