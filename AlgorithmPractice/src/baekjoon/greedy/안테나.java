package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ¾ÈÅ×³ª {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(strs[i]);
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		Arrays.sort(arr);
		return arr[arr.length/2 -1 ];
	}

}
