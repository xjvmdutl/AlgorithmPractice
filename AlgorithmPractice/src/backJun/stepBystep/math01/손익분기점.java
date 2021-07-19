package backJun.stepBystep.math01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 손익분기점 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);
		int c = Integer.parseInt(strs[2]);
		System.out.println(solution(a,b,c));
	}

	private static int solution(int a, int b, int c) {
		if(b >= c)
			return -1;
		int answer = a / (c-b);

		return answer+1;
	}

}
