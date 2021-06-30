package progammers.level2;

import java.util.Stack;

public class 괄호회전하기 {
	public static int solution(String s) {
        int answer = 0;
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder(s);
        
        for(int i=0;i<s.length();++i) {
        	sb = new StringBuilder(s.substring(i));
        	sb.append(s.substring(0,i));
        	stack = new Stack<>();
        	for(char c : sb.toString().toCharArray()) {
        		if(!stack.isEmpty() && (c==')' || c==']' || c=='}')) {
        			char tmp = stack.pop();
        			boolean ischk = false;
        			switch(c) {
        			case ')' :
        				ischk = tmp == '(' ? true : false;
        				break;
        			case ']' :
        				ischk = tmp == '[' ? true : false;
        				break;
        			case '}' :
        				ischk = tmp == '{' ? true : false;
        				break;
        			}
        			if(!ischk) {
        				stack.push(tmp);
        				break;
        			}
        		}else {
        			stack.push(c);
        		}
        	}
        	if(stack.isEmpty()) {
        		answer++;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//s	result
		//"[](){}"	3
		//"}]()[{"	2
		//"[)(]"	0
		//"}}}"	0
		String s1 = "[](){}";
		String s2 = "}]()[{";
		String s3 = "[)(]";
		String s4 = "}}}";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
	}

}
