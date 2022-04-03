package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Àü±¸ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		boolean[] arr = new boolean[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i =0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken()) == 1 ? true : false;
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			if(a == 1) {
				int index = Integer.parseInt(tokens.nextToken()) - 1;
				int x = Integer.parseInt(tokens.nextToken());
				arr[index] = x == 1 ? true : false;
			}else {
				int l = Integer.parseInt(tokens.nextToken()) - 1;
				int r = Integer.parseInt(tokens.nextToken()) - 1;
				solution(arr, l , r, a);
			}
		}
		System.out.println(print(arr));
	}

	private static String print(boolean[] arr) {
		StringBuilder sb = new StringBuilder();
		for(boolean flag : arr) {
			sb.append((flag == true ? 1 : 0 )+ " ");
		}
		return sb.toString();
	}

	private static void solution(boolean[] arr, int l, int r, int a) {
		if(a == 2) {
			for(int j = l; j <= r; ++j) {
				change(arr, j, arr[j] == true ? false : true);
			}	
		}else if(a == 3) {
			for(int j = l; j <= r; ++j) {
				change(arr, j, false);
			}
		}else {
			for(int j = l; j <= r; ++j) {
				change(arr, j, true);
			}
		}
	}

	private static void change(boolean[] arr, int j, boolean b) {
		arr[j] = b;
	}

}
