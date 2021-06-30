package progammers.level2;

import java.util.Stack;

public class 짝지어제거하기 {
	
	public static int solution(String s){
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
        	if(!stack.isEmpty() &&stack.peek() == c ) {
        		stack.pop();
        	}else {
        		stack.push(c);
        	}
        }
        return stack.isEmpty() ? 1 : 0;
    }
	public static void main(String[] args) {
//		s	result
//		baabaa	1
//		cdcd	0
		String s1 = "baabaa";
		String s2 = "cdcd";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}

}


