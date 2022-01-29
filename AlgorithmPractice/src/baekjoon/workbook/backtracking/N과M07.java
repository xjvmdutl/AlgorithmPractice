package baekjoon.workbook.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N°úM07 {
	public static StringBuilder sb;
	public static int[] select;
	private static String solution(int[] array, int n, int m) {
		sb = new StringBuilder();
		select = new int[m];
		Arrays.sort(array);
		backtracking(array, 0, m);
		return sb.toString();
	}
	
	
	private static void backtracking(int[] array, int count, int m) {
		if(count == m) {
			for(int i=0;i<select.length;++i) {
				sb.append(select[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<array.length;++i) {
			select[count] = array[i]; 
			backtracking(array, count+1, m);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int[] array = new int[N];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<N;++i) {
			array[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(array,N,M));
	}
}
