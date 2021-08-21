package baekjoon.stepbystep.fortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APlusB8 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			String[] strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			System.out.println("Case #" + (i+1) + ": "+solution(a,b));
		}
	}

	private static int solution(int a, int b) {
		return a+b;
	}

}
