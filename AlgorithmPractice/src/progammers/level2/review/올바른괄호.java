package progammers.level2.review;

import java.util.Stack;

public class ¿Ã¹Ù¸¥°ýÈ£ {
	public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();++i) {
        	if(stack.isEmpty() && s.charAt(i) == ')') {
        		return false;
        	}
        	char c = s.charAt(i);
        	if(c == '(') {
        		stack.push(c);
        	}else {
        		stack.pop();
        	}
        }
        return stack.size() > 0 ? false : true;
    }
	public static void main(String[] args) {
		//s	answer
		//"()()"	true
		//"(())()"	true
		//")()("	false
		//"(()("	false
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
		System.out.println(solution("(()("));
	}

}
