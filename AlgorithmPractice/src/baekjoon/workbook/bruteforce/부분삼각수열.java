package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분삼각수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i <n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
		
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		
		return answer;
	}

}
