package baekjoon.greedy;

import java.util.Scanner;
import java.util.Stack;

public class ÀÒ¾î¹ö¸°°ýÈ£ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(solution(str));
	}

	private static int solution(String str) {
		String tmp = str.replace('+', ',').replace('-', ',');
		String[] strs = tmp.split(",");
		int[] numbers = new int[strs.length];
		for(int i=0;i<strs.length;++i) {
			numbers[i] = Integer.parseInt(strs[i]);
		}
		int idx = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(numbers[idx++]);
		for(char c : str.toCharArray()) {
			if(c == '+') {
				stack.push(stack.pop() + numbers[idx++]);
			}else if(c == '-') {
				stack.push(numbers[idx++]);
			}
		}
		int result = 0;
		while(!stack.isEmpty()) {
			if(stack.size() ==1) {
				result += stack.pop();
				break;
			}
			result -= stack.pop();
			
		}
		
		return result;
	}

}
