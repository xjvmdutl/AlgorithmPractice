package baekjoon.stepbystep.onearray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최소최대 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(strs[i]);
		System.out.println(solution(arr,n));
		
	}

	private static String solution(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		int min = arr[0];
		int max = arr[0];
		for(int i = 1;i<arr.length;++i) {
			if(min > arr[i])
				min = arr[i];
			if(max < arr[i])
				max = arr[i];
		}
		sb.append(min + " " + max);
		return sb.toString();
	}

}
