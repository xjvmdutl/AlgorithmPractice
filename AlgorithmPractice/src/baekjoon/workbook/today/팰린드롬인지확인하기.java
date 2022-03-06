package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬인지확인하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
		
	}

	private static int solution(String str) {
		boolean answer = true;
		for(int i=0;i<str.length()/2;++i) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(str.length()-1-i);
			if(c1 != c2) {
				answer = false;
				break;
			}
		}
		
		return answer ? 1 : 0;
	}

}
