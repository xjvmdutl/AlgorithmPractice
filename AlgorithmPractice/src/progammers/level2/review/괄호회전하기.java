package progammers.level2.review;

import java.util.Stack;

public class 괄호회전하기 {
	 public static int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();++i) {
        	String str = s.substring(i) + s.substring(0,i);
        	Stack<Character> stack = new Stack<>();
        	boolean flag = true;
        	for(char c : str.toCharArray()) {
        		if(stack.isEmpty() && (c == ']' || c == ')' || c == '}' ) ) {
        			flag = false;
        			break;
        		}else if(c == '}' || c == ')' || c == ']') {
        			if(c == '}') {
        				char tmp = stack.pop();
        				if(tmp != '{') {
        					flag = false;
        					break;
        				}
        			}else if(c == ')') {
        				char tmp = stack.pop();
        				if(tmp != '(') {
        					flag = false;
        					break;
        				}
        			}else if(c == ']') {
        				char tmp = stack.pop();
        				if(tmp != '[') {
        					flag = false;
        					break;
        				}
        			}
        		}else {
        			stack.push(c);
        		}
        	}
        	if(flag) {
        		if(stack.isEmpty()) {
        			answer++;
        		}
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
		//"{{{{{{}" 0
		System.out.println(solution("[](){}"));
		System.out.println(solution("}]()[{"));
		System.out.println(solution("[)(]"));
		System.out.println(solution("}}}"));
		System.out.println(solution("{{{{{{}"));
	}

}
