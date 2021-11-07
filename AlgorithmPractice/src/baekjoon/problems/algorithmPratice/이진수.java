package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ÀÌÁø¼ö {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			System.out.println(solution(n));
		}
	}

	private static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		String binary = Integer.toBinaryString(n);
		for(int i=binary.length()-1;i>=0;--i)
			if(binary.charAt(i) == '1')
				sb.append(binary.length()-1-i + " ");
		return sb.toString();
	}

}
