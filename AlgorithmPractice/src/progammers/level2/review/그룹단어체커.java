package progammers.level2.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 그룹단어체커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int answer = 0;
		for(int i=0;i<n;++i) {
			if(solution(reader.readLine())) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		for(int i=1;i<s.length();++i) {
			if(stack.peek() == s.charAt(i)) {
				continue;
			}else {
				if(stack.contains(s.charAt(i))) {
					return false;
				}else {
					stack.push(s.charAt(i));
				}
			}			
		}
		
		
		return true;
	}

}
