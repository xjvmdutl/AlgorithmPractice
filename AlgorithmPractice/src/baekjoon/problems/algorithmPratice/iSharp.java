package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class iSharp {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		StringBuilder sb = new StringBuilder();
		StringTokenizer tokens = new StringTokenizer(str);
		String start = tokens.nextToken();
		while(tokens.hasMoreTokens()) {
			String now = tokens.nextToken();
			StringBuilder tmp = new StringBuilder(start);
			Stack<Character> stack = new Stack<>();
			int index = 0;
			for(int i=0;i<now.length()-1;++i) {
				char c = now.charAt(i);
				if(c == '[' || c == ']' || c == '*' || c == '&') {
					stack.push(c);
				}else {
					index = i;
				}
			}
			while(!stack.isEmpty()) {
				char c = stack.pop();
				if(c == ']')
					c = '[';
				else if(c == '[')
					c = ']';
				tmp.append(c);
			}
			tmp.append(" " + now.substring(0,index+1) + ";\n");
			sb.append(tmp.toString());
		}
		return sb.toString();
	}

}
