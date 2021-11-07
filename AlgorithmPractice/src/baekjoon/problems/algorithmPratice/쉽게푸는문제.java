package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쉽게푸는문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokens.nextToken());
		int b = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(a,b));
	}

	private static int solution(int a, int b) {
		int index = 0;
		int sum = 0;
		for(int i=1;index<=1000;++i) {
			for(int j=1;j<=i;++j) {
				index++;
				if(a <= index && index <= b)
					sum += i;
			}
		}
		return sum;
	}

}
