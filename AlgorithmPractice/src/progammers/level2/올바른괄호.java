package progammers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class ¿Ã¹Ù¸¥°ýÈ£ {
	public static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && c == ')')
                stack.pop();
            else
                stack.push(c);
        }
        return stack.isEmpty() ? true:false;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		s	answer
//		"()()"	true
//		"(())()"	true
//		")()("	false
//		"(()("	false
		String s1 = "()()";
		String s2 = "(())()";
		String s3 = ")()(";
		String s4 = "(()(";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
		
		
	}

}
