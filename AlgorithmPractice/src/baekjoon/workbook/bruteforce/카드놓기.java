package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 카드놓기 {
	private static Set<String> result;
	private static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int k = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr, n, k));
	}

	private static int solution(int[] arr, int n, int k) {
		result= new HashSet<>();
		visit = new boolean[n];
		permutation(arr, n, 0, k, new int[n]);
		return result.size();
	}

	private static void permutation(int[] arr, int n, int count, int size, int[] r) {
		if(count == size) {
			StringBuilder answer = new StringBuilder();
			for(int number : r)
				answer.append(number);
			result.add(answer.toString());
			return;
		}
		for(int i=0;i<n;++i) {
			if(!visit[i]) {
				visit[i] = true;
				r[count] = arr[i];
				permutation(arr, n, count+1, size, r);
				visit[i] = false;
			}
		}
	}

}
