package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class æ–√‡ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static int solution(String str) {
		int count = 0;
		int last = 0;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> lastDatas = new Stack<>();
		for(int i=0;i<str.length();++i) {
			if(str.charAt(i) == '(') {
				stack.push(count);
				count = 0;
				lastDatas.push(last);
			}else if(str.charAt(i) == ')') {
				int number = lastDatas.pop();
				int l = stack.pop()-1;
				count = count*number + l; 
			}else {
				count++;
				last = str.charAt(i)-'0';
			}
		}
		return count;
	}

}
