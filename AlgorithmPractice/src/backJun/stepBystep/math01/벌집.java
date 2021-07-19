package backJun.stepBystep.math01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ¹úÁý {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 0;
		int count = 1;
		while(count < n) {
			answer++;
			count += 6*answer;
		}
		return answer+1;
	}

}
