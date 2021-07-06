package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class дех╕╢У {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String str = reader.readLine();
		System.out.println(solution(n,str));
		
	}

	private static int solution(int n, String str) {
		int answer = 1;
		for(int i = 0;i<str.length();++i) {
			char c = str.charAt(i);
			if(c == 'S') {
				answer ++;
			}else if(c == 'L') {
				i++;
				answer++;
			}
		}
		
		return answer;
	}

}
