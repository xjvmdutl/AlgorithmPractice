package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N°úM11 {
	public static StringBuilder sb;
	public static Set<String> set;
	public static int[] per;
	public static void main(String[] args) throws IOException {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr, n, m));
	}

	private static String solution(int[] arr, int n, int m) {
		Arrays.sort(arr);
		set = new HashSet<String>();
		per = new int[m];
		sb = new StringBuilder();
		permulate(arr, 0, n, m);
		return sb.toString();
	}

	private static void permulate(int[] arr, int count, int n, int m) {
		if(count == m) {
			StringBuilder builder = new StringBuilder();
			for(int num : per) {
				builder.append(num + " ");
			}
			if(!set.contains(builder.toString())) {
				sb.append(builder.toString() + "\n");
				set.add(builder.toString());
			}
			return;
		}
		for(int i=0;i<n;++i) {
			per[count] = arr[i];
			permulate(arr, count+1, n, m);
		}
	}

}
