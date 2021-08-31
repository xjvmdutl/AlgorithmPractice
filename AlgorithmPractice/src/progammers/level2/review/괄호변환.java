package progammers.level2.review;

import java.util.Stack;

public class °ýÈ£º¯È¯ {
	public static String solution(String p) {
        String answer = "";
        if(p.length() < 1) {
        	return p;
        }
        int open = 0;
		int close = 0;
		String u = "";
		String v = "";
        for(int i=0;i<p.length();++i) {
        	char c = p.charAt(i);
			if(c == '(')
				open++;
			else
				close++;
			if(open == close) {
				u = p.substring(0,i+1);
				v = p.substring(i+1);
				break;
			}
		}
        if(isOkay(u)) {
        	return u+solution(v);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(" + solution(v) + ")");
        sb.append(reverse(u.substring(1,u.length()-1)));
        return sb.toString();
    }
	private static String reverse(String u) {
		StringBuilder sb = new StringBuilder();
		for(char c : u.toCharArray()) {
			if(c == '(') {
				sb.append(')');
			}else {
				sb.append('(');
			}
		}
		return sb.toString();
	}
	private static boolean isOkay(String u) {
		Stack<Character> stack = new Stack<Character>();
		for(char c : u.toCharArray()) {
			if(c == '(') {
				stack.push(c);
			}else {
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.size() > 0 ? false : true;
	}
	public static void main(String[] args) {
		//p				result
		//"(()())()"	"(()())()"
		//")("			"()"
		//"()))((()"	"()(())()"
		System.out.println(solution("(()())()"));
		System.out.println(solution(")("));
		System.out.println(solution("()))((()"));
	}

}
