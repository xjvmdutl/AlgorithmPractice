package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ¼öÃ£±â {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(reader.readLine());
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<m;++i) {
			int num = Integer.parseInt(tokens.nextToken());
			System.out.println(solution(arr,num));
		}
	}

	private static int solution(int[] arr, int num) {
		int index = Arrays.binarySearch(arr, num);
		return index >= 0 ? 1 : 0;
	}
}
