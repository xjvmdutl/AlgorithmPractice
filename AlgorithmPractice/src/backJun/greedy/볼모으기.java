package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 볼모으기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[] arr = new char[n];
		String[] strs = reader.readLine().split("");
		for(int i =0;i<n;++i)
			arr[i] = strs[i].charAt(0);
		//System.out.println(solution(arr,n,'B'));
		System.out.println(solution(arr,n,'R'));		
	}

	private static int solution(char[] arr, int n,char collor) {
		int answer = 0;
		for(int i=0;i<arr.length;++i) {
			char c = arr[i];
			Stack<Character> stack = new Stack<>();
			if(c == collor) {
				stack.push(c);
				for(int j=i+1;j<arr.length;++j) {
					if(c==arr[j]) {
						stack.push(arr[j]);
					}else {
						break;
					}
				}
				if(!stack.isEmpty()) {
					swap(arr,i,i+stack.size());
					answer++;
				}
			}
			
		}
		
		return answer;
	}

	private static void swap(char[] arr,int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
