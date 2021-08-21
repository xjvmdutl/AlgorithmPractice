package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class µÚÁý±â {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
		
	}

	private static int solution(String str) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		char data = str.charAt(0);
		for(int i=1;i<str.length();++i) {
			char c = str.charAt(i);
			if(data != c) {
				count++;
				while(c!=data) {
					if(i>=str.length()-1)
						break;
					i++;
					c=str.charAt(i);
				}
			}
		}
			
		return count;
	}

}
