package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Pillar {
    int left;
    int height;
    public Pillar(int left, int height) {
        this.left = left;
        this.height = height;
    }
}
public class 창고다각형 {

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
		Arrays.sort(arr, (o1,o2)->o1[0] - o2[0]);
		Stack<Pillar> rightStack = new Stack<Pillar>();
		Stack<Pillar> leftStack = new Stack<Pillar>();
		int maxHeight = 0;
		for(int i=0;i<arr.length;++i) {
			if(maxHeight < arr[i][1]) {
				maxHeight = arr[i][1];
				leftStack.push(new Pillar(arr[i][0], arr[i][1]));
			}
		}
		maxHeight = 0;
		for(int i=arr.length-1;i>=0;--i) {
			if(maxHeight < arr[i][1]) {
				maxHeight = arr[i][1];
				rightStack.push(new Pillar(arr[i][0], arr[i][1]));
			}
		}
		int answer = (rightStack.peek().left - leftStack.peek().left + 1) * rightStack.peek().height;
		int beforeLeft = leftStack.pop().left;
		while(!leftStack.isEmpty()) {
            int left = leftStack.peek().left;
            int height = leftStack.peek().height;
            answer += (beforeLeft - left) * height;
            beforeLeft = left;
            leftStack.pop();
        }
		int beforeRight = rightStack.pop().left;
		while(!rightStack.isEmpty()) {
            int left = rightStack.peek().left;
            int height = rightStack.peek().height;
            answer += (left - beforeRight) * height;
            beforeRight = left;
            rightStack.pop();
        }
		
		
		return answer;
	}

}
