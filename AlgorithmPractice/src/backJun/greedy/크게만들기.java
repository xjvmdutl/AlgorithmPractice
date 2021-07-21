package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 크게만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int k = Integer.parseInt(strs[1]);
		String number = reader.readLine();
		System.out.println(solution(n,k,number));
	}

	private static String solution(int n, int k, String number) {
		int length = n-k;
		char[] arr = number.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<arr.length;++i) {
			while(!stack.isEmpty() && k > 0 && stack.peek() < arr[i]) {
				k--;
				stack.pop();
			}
			stack.push(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<length; i++) {
           sb.append(stack.get(i));
        }
		return sb.toString();
	}

}
