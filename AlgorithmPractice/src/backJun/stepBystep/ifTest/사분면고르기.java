package backJun.stepBystep.ifTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사분면고르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(reader.readLine());
		int y = Integer.parseInt(reader.readLine());
		System.out.println(solution(x,y));
	}

	private static int solution(int x, int y) {
		int answer = 0;
		if(x > 0 && y > 0)
			answer = 1;
		else if(x < 0 && y > 0)
			answer = 2;
		else if(x < 0 && y < 0)
			answer = 3;
		else
			answer = 4;
		return answer;
	}

}
