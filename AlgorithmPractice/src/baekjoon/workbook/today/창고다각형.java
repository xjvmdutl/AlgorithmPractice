package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Stock{
	int index;
	int length;
	public Stock(int index, int length){
		this.index = index;
		this.length = length;
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
		Stack<Stock> leftStk = new Stack<>();
		Stack<Stock> rightStk = new Stack<>();
		int maxHeight = 0;
		for(int i = 0; i < n; i++) {
            if(maxHeight < arr[i][1]) {
                maxHeight = arr[i][1];
                leftStk.push(new Stock(arr[i][0], arr[i][1]));        
            }
        }
		maxHeight = 0;
		for(int i = n - 1; i >= 0; i--) {
            if(maxHeight < arr[i][1]) {
                maxHeight = arr[i][1];
                rightStk.push(new Stock(arr[i][0], arr[i][1]));
            }
        }
		int answer = (rightStk.peek().index - leftStk.peek().index + 1) * rightStk.peek().length;
		int beforeLeft = leftStk.pop().index;
		while(!leftStk.isEmpty()) {
            int left = leftStk.peek().index;
            int height = leftStk.peek().length;
            answer += (beforeLeft - left) * height;
            beforeLeft = left;
            leftStk.pop();
        }
		int beforeRight = rightStk.pop().index;
		while(!rightStk.isEmpty()) {
            int left = rightStk.peek().index;
            int height = rightStk.peek().length;
            answer += (left - beforeRight) * height;
            beforeRight = left;
            rightStk.pop();
        }
		return answer;
	}

}
