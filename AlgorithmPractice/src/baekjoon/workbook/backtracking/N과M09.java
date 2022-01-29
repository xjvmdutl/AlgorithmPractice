package baekjoon.workbook.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class N°úM09 {
	public static int[] select;
	public static boolean[] visit;
	public static StringBuilder answer;
	public static Set<String> set;
	private static String solution(int[] array, int n, int m) {
		select = new int[m];
		set = new HashSet<>();
		answer = new StringBuilder();
		visit = new boolean[n];
		Arrays.sort(array);
		backtracking(array, 0, m);
		return answer.toString();
	}
	
	
	private static void backtracking(int[] array, int count, int m) {
		if(count == m) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<select.length;++i) {
				sb.append(select[i] + " ");
			}
			if(!set.contains(sb.toString())) {
				answer.append(sb.toString());
				answer.append("\n");
				set.add(sb.toString());
			}
			return;
		}
		for(int i=0;i<array.length;++i) {
			if(!visit[i]) {
				visit[i] = true;
				select[count] = array[i]; 
				backtracking(array, count+1, m);
				visit[i] = false;
			}
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
