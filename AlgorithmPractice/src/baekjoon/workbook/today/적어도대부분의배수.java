package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적어도대부분의배수 {
	public static int answer;
	public static boolean[] visit;
	public static int[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[5];
		for(int i=0;i<5;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		answer = Integer.MAX_VALUE;
		visit = new boolean[5];
		selected = new int[3];
		permulate(arr, 0, 3);
		return answer;
	}

	private static void permulate(int[] arr, int count, int length) {
		if(count == length) {
			int first = selected[0] * selected[1] / gcd(Math.max(selected[0], selected[1])
					, Math.min(selected[0], selected[1]));
			int result = first * selected[2] / gcd(Math.max(first, selected[2])
					, Math.min(first, selected[2]));
			answer = Math.min(answer, result);
			return;
		}
		for(int i=0;i<5;++i) {
			if(!visit[i]) {
				visit[i] = true;
				selected[count] = arr[i];
				permulate(arr, count+1, length);
				visit[i] = false;
			}
		}
	}

	private static int gcd(int x, int y) {
		if(y == 0) {
			return x;
		}
		return gcd(y, x%y);
	}

}
