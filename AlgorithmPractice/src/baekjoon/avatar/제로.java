package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Á¦·Î {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<arr.length;++i) {
			if(!stack.isEmpty() && arr[i] == 0) {
				stack.pop();
				continue;
			}
			stack.push(arr[i]);
		}
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}

}
