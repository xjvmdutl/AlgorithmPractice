package progammers.level2;

import java.util.Stack;

public class °ýÈ£º¯È¯ {
	
	public static String solution(String p) {
		if(p.isEmpty()) return p;
		StringBuilder u = new StringBuilder();
		StringBuilder v = new StringBuilder();
		int leftCount = 0;
		int rightCount = 0;
		
		for(int i=0;i<p.length();++i) {
			char c = p.charAt(i);
			if(c == '(') {
				leftCount++;
			}else {
				rightCount++;
			}
			if(leftCount == rightCount) {
				u = new StringBuilder(p.substring(0,i+1));
				v = new StringBuilder(p.substring(i+1));
				break;
			}
		}
		if(isCorrect(u.toString())) {
			return u.append(solution(v.toString())).toString();
		}
		StringBuilder answer = new StringBuilder();
		answer.append('(').append(solution(v.toString())).append(')');
		u.deleteCharAt(0);
		u.deleteCharAt(u.length()-1);
		answer.append(swap(u.toString()));
		
        return answer.toString();
    }
	
	private static String swap(String u) {
		StringBuilder tmp = new StringBuilder();
		for(char c : u.toCharArray()) {
			if(c == '(')
				tmp.append(')');
			else
				tmp.append('(');
		}
		return tmp.toString();
	}

	private static boolean isCorrect(String u) {
		Stack<Character> stack = new Stack<>();
		for(char c : u.toCharArray()) {
			if(c == '(') {
				stack.push(c);
			}else {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}
		}
		return stack.size() < 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//p	result
		//"(()())()"	"(()())()"
		//")("			"()"
		//"()))((()"	"()(())()"
		String p1 = "(()())()";
		String p2 = ")(";
		String p3 = "())))(((()";
		System.out.println(solution(p1));
		System.out.println(solution(p2));
		System.out.println(solution(p3));
		
	}

}

