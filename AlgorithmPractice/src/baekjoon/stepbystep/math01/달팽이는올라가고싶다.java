package baekjoon.stepbystep.math01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달팽이는올라가고싶다 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);
		int v = Integer.parseInt(strs[2]);
		System.out.println(solution(a,b,v));
		
	}

	private static int solution(int a, int b, int v) {
		double n = ((double)v - a) / (a-b);
		int answer = (int) (Math.ceil(n));
				
		return answer+1;
	}
}
