package baekjoon.stepbystep.fortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class X보다작은수 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int x = Integer.parseInt(strs[1]);
		int[] arr = new int[n];
		strs = reader.readLine().split(" ");
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(strs[i]);
		System.out.println(solution(arr,x));
	}

	private static String solution(int[] arr, int x) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;++i) {
			if(arr[i] >= x)
				continue;
			sb.append(arr[i] + " ");
		}
		if(sb.length() > 0)
			sb.delete(sb.length()-1, sb.length());
		return sb.toString();
	}

}
