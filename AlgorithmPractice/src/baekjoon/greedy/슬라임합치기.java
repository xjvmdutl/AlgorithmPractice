package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 슬라임합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(strs[i]);
		System.out.println(solution(n,arr));
	}

	private static int solution(int n, int[] arr) {
		int answer = 0;
		int[] reverse = Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		Stack<Integer> stack = new Stack<>();
		stack.push(reverse[0]);
		for(int i=1;i<reverse.length;++i) {
			int num = stack.pop();
			answer += num * reverse[i];
			stack.push(num+reverse[i]);
		}
		return answer;
	}

}
