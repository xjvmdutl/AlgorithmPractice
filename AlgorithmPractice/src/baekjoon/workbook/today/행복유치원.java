package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class 행복유치원 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i)
			arr[i]= Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr, n, k));
	}

	private static int solution(int[] arr, int n, int k) {
		int answer = 0;
		Arrays.sort(arr);
		int[] diff = new int[n-1];
		for(int i=1;i<n;++i) {
			diff[i-1] = arr[i] - arr[i-1];
		}
		Arrays.sort(diff);
		for(int i=0;i<n-k;++i) {
			answer += diff[i];
		}
		return answer;
	}

}
