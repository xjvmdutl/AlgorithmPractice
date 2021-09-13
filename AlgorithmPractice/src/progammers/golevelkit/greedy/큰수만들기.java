package progammers.golevelkit.greedy;

import java.util.Stack;

public class 큰수만들기 {
	public static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<number.length();++i) {
        	char c = number.charAt(i);
        	while(!stack.isEmpty() && stack.peek() < c && k-- > 0) {
        		stack.pop();
        	}
        	stack.push(c);
        }
        while(k-- > 0) {
        	stack.pop();
        }
        StringBuilder sb= new StringBuilder();
        while(!stack.isEmpty()) {
        	sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		//number	k	return
		//"1924"	2	"94"
		//"1231234"	3	"3234"
		//"4177252841"	4	"775841"
		String number1 = "1924";
		int k1 = 3;
		System.out.println(solution(number1,k1));
		String number2 = "1231234";
		int k2 = 3;
		System.out.println(solution(number2,k2));
		String number3 = "4177252841";
		int k3 = 4;
		System.out.println(solution(number3,k3));
		String number4 = "12345678901234567890";
		int k4 = 1;
		System.out.println(solution(number4,k4));
	}
}
