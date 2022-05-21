package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ºÐÇØÇÕ {
	private static int solution(int n) {
		int answer = Integer.MAX_VALUE;
		for(int i=1;i<=n;++i) {
			int num = i;
			int next = i;
			while(num > 0) {
				next += num % 10;
				num /= 10;
			}
			if(next == n) {
				answer = Math.min(answer, i);
			}
		}
		return answer == Integer.MAX_VALUE ? 0 : answer; 
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	

}
