package backJun.stepBystep.whileTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APlusB4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = reader.readLine()) != null) {
			String[] strs = s.split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			System.out.println(solution(a,b));
		}
	}

	private static int solution(int a, int b) {
		return a+b;
	}

}
