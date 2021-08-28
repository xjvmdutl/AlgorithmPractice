package progammers.level2.review;

import java.util.Stack;

public class 문자열압축 {
	public static int solution(String s) {
        int answer = s.length();
        for(int i=1;i<=s.length();++i) {
        	StringBuilder sb = new StringBuilder();
        	Stack<String> stack = new Stack<>();
        	int count  = 1;
        	stack.push(s.substring(0,i));
        	for(int idx=i;idx<s.length();idx+=i) {
        		String str;
        		if(idx + i < s.length()) {
        			str = s.substring(idx,idx+i);
        		}else {
        			str = s.substring(idx,s.length());
        		}
        		if(str.equals(stack.peek())) {
        			count++;
        			continue;
        		}
        		if(count == 1) {
        			sb.append(stack.pop());
        		}else {
        			sb.append(count+stack.pop());
        		}
        		count = 1;
        		stack.push(str);
        	}
        	if(!stack.isEmpty()) {
        		if(count == 1) {
        			sb.append(stack.pop());
        		}else {
        			sb.append(count+stack.pop());
        		}
        	}
        	answer = Math.min(answer, sb.length());
        }
        return answer;
    }
	public static void main(String[] args) {
		//s	result
		//"aabbaccc"	7
		//"ababcdcdababcdcd"	9
		//"abcabcdede"	8
		//"abcabcabcabcdededededede"	14
		//"xababcdcdababcdcd"	17
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
		
	}

}
