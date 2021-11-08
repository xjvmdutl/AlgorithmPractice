package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class °ýÈ£ÀÇ°ª {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		int tmp = 1;
		int answer = 0;
		for(int i=0;i<s.length();++i) {
			char c = s.charAt(i);
			if(c == ')' || c == ']') {
				if(stack.isEmpty())
					return 0;
				if(stack.peek() == '(' && c == ')') {
					if (s.charAt(i-1)== '(')
                        answer += tmp;
					stack.pop();
					tmp/=2;
				}else if(stack.peek() == '[' && c == ']') {
					if (s.charAt(i-1)== '[')
                        answer += tmp;
					stack.pop();
					tmp/=3;
				}else 
					return 0;
			}else {
				if(c == '(')
					tmp *= 2;
				else
					tmp *= 3;
				stack.push(c);
			}
		}
		
		
		return stack.size() > 0 ? 0 : answer;
	}

}
