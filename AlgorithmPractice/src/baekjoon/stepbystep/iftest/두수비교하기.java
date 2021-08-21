package baekjoon.stepbystep.iftest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 두수비교하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		System.out.println(solution(a,b));
	}

	private static String solution(int a, int b) {
		StringBuilder sb= new StringBuilder();
		if(a < b) 
			sb.append("<");
		else if(a > b)
			sb.append(">");
		else
			sb.append("==");
		return sb.toString();
	}
}
