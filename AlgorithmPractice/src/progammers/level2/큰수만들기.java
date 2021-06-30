package progammers.level2;

import java.util.Stack;

public class ū������� {
	
	 public static String solution(String number, int k) {
		 char[] result = new char[number.length() - k];
	        Stack<Character> stack = new Stack<>();

	        for (int i=0; i<number.length(); i++) {
	            char c = number.charAt(i);
	            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
	                stack.pop();
	            }
	            stack.push(c);
	        }
	        for (int i=0; i<result.length; i++) {
	            result[i] = stack.get(i);
	        }
	        return new String(result);
	    
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//number	k	return
		//"1924"	2	"94"
		//"1231234"	3	"3234"
		//"4177252841"	4	"775841"
		String number1 = "1924";
		int k1 = 2;
		System.out.println(solution(number1, k1));
		String number2 = "1231234";
		int k2 = 3;
		System.out.println(solution(number2, k2));
		String number3 = "4177252841";
		int k3 = 4;
		System.out.println(solution(number3, k3));
	}

}
