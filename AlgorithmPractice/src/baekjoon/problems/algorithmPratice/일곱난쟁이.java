package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ¿œ∞ˆ≥≠¿Ô¿Ã {
	public static boolean[] visit;
	public static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		for(int i=0;i<9;++i)
			arr[i] = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr));
	}

	private static String solution(int[] arr) {
		flag = false;
		visit = new boolean[9];
		int[] nanjang = new int[7];
		dfs(arr,0,7,nanjang);
		Arrays.sort(nanjang);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<nanjang.length;++i)
			sb.append(nanjang[i] + " ");
		return sb.toString();
	}

	private static void dfs(int[] arr, int index, int length, int[] nanjang) {
		if(index == length) {
			int sum = 0;
			for(int i=0;i<nanjang.length;++i)
				sum += nanjang[i];
			if(sum == 100)
				flag = true;
			return;
		}
		for(int i=0;i<arr.length;++i) {
			if(!visit[i] && !flag) {
				visit[i] = true;
				nanjang[index] = arr[i];
				dfs(arr, index+1, length, nanjang);
				visit[i] = false;
			}
		}
	}

}
