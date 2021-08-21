package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PPAP {

	public static void main(String[] args) throws IOException {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		Stack<Character> stack = new Stack<>();
		for(int i =0;i<str.length();++i) {
			char c = str.charAt(i);
			if(c == 'P')
				stack.push(c);
			else{//'A'
				if(stack.size() >= 2 && i < str.length()-1 && str.charAt(i+1) == 'P') {
					stack.pop();
					stack.pop();
				}else {
					return "NP";
				}
			}
		}
		return stack.size() == 1 ? "PPAP" : "NP";
	}

}
