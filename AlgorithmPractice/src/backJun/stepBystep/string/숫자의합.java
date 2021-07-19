package backJun.stepBystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String str = reader.readLine();
		System.out.println(solution(str,n));
	}

	private static int solution(String str, int n) {
		int answer = 0;
		for(int i=0;i<str.length();++i) {
			answer += Character.getNumericValue(str.charAt(i));
		}
		return answer;
	}

}
