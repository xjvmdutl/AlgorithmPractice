package baekjoon.stepbystep.whiletest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기사이클 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 0;
		int num = n;
		while(true) {
			int i = num;
			if(num >= 10)
				num = num%10 + num/10;
			else
				num = num+10;
			num = (i%10)*10 + num%10;
			answer++;
			
			if(num == n)
				break;
		}
		return answer;
	}

}
