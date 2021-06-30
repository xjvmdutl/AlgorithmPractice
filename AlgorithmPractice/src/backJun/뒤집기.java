package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class µÚÁý±â {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		int count = 0;
		while(true) {
			count++;
			Stack<Character> stack = new Stack<>();
			stack.push(str.charAt(0));
			Stack<Character> stack2 = new Stack<>();
			for(int i=1;i<str.length();++i) {
				char c = str.charAt(i);
				if(stack.peek() != c) {
					stack2.push(c);
				}else {
					stack.push(c);
				}
			}
		}
	}

}
