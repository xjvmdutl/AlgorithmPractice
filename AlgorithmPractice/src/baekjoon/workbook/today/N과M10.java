package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N°úM10 {
	public static boolean[] visit;
	public static StringBuilder sb;
	public static int[] per;
	public static Set<String> set;
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

	private static String solution(int[] arr, int n, int m) {
		visit = new boolean[n];
		sb =  new StringBuilder();
		set = new HashSet<>();
		per = new int[m];
		Arrays.sort(arr);
		backTracking(arr, 0, m, 0, n);
		return sb.toString();
	}

	private static void backTracking(int[] arr, int count, int m, int index, int n) {
		if(count == m) {
			StringBuilder builder = new StringBuilder();
			for(int num : per) {
				builder.append(num + " ");
			}
			builder.append("\n");
			if(!set.contains(builder.toString())) {
				set.add(builder.toString());	
				sb.append(builder.toString());
			}
			return;
		}
		for(int i=index;i<n;++i) {
			if(!visit[i]) {
				visit[i] = true;
				per[count] = arr[i];
				backTracking(arr, count+1, m, i, n);
				visit[i] = false;
			}
		}
	}
}
