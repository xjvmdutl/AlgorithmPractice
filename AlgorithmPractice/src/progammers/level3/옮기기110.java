package progammers.level3;

import java.util.Stack;

public class 옮기기110 {
    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i=0;i<s.length;++i) {
        	answer[i] = solve(s[i]);
        }
        return answer;
    }
	private static String solve(String str) {
		Stack<Character> stack = new Stack<>();
		int count = 0;
		for(int i=0;i<str.length();++i) {
			stack.push(str.charAt(i));
			if(stack.size() >= 3) {
				char first = stack.pop();
				char second = stack.pop();
				char third = stack.pop();
				if(third == '1' && second == '1' && first == '0') {
					count++;
				}else {
					stack.push(third);
					stack.push(second);
					stack.push(first);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int pos = stack.size();
		boolean first = false;
		while(!stack.isEmpty()) {
			char c = stack.pop();
			if(c == '1' && !first)
				pos--;
			if(c == '0')
				first = true; //최초 
			sb.insert(0, c);
		}
		for(int i=0;i<count;++i)
			sb.insert(pos, "110");
		System.out.println(sb.toString());
		return sb.toString();
	}
	public static void main(String[] args) {
		String[] s1 = {"1110","100111100","0111111010","1101110"};
		System.out.println(solution(s1));
	}

}
