package test.ahnlab;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class test04 {
	public static int[] solution(String s, int[] idx) {
        int[] answer = new int[idx.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Character> correctStack = new Stack<>();

        for(int i=0;i<s.length();++i) {
        	char c = s.charAt(i);
        	if(c == '{') {
        		correctStack.push(c);
        		map.put(i, -1);
        		stack.push(i);
        	}else if(c == '}'){
        		if(correctStack.isEmpty()) {
        			throw new IllegalArgumentException();
        		}
        		correctStack.pop();
        		int index = stack.pop();
        		map.put(i, index);
        		map.put(index, i);
        	}
        }
        for(int i=0;i<idx.length;++i) {
        	answer[i] = map.get(idx[i]);
        }
        return answer;
    }
	public static void main(String[] args) {
		String str1 = "{cpp{java}}{python}";
		int[] index1 = {0, 4, 9, 10, 11, 18};
		System.out.println(solution(str1, index1));
		String str2 = "}{";
		int[] index2 = {0 , 1};
		System.out.println(solution(str2, index2));
	}
}
