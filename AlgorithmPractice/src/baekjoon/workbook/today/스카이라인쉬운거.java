package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스카이라인쉬운거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		Arrays.sort(arr, (o1,o2)->{
			return o1[0] - o2[0];
		});
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<n;++i) {
			while(!stack.isEmpty() && stack.peek() > arr[i][1]) {
				stack.pop();
			}
			if(!stack.isEmpty() && arr[i][1] == stack.peek())
				continue;
			if(arr[i][1] == 0)
				continue;
			stack.push(arr[i][1]);
			answer++;
		}
		return answer;
	}

}
