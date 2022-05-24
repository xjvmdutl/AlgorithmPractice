package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourSquares {
	private static int solution(int n) {
		int answer = 0;
		for(int i=0;i * i <=n;++i) {
			for(int j=0; j * j <=n - (i * i); ++j) {
				for(int k=0; k * k <=n - (i * i) - (j * j);++k) {
					for(int l=0;l * l <= n - (i * i) - (j * j) - (k * k);++l) {
						
					}	
				}	
			}	
		}
		return answer;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}



}
