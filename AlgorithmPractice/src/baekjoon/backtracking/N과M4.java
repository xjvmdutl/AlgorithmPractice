package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N°úM4 {
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,m));
	}
	private static String solution(int n, int m) {
		sb = new StringBuilder();
		int[] per = new int[m];
		permulate(1,n,0,m,per);
		return sb.toString();
	}
	private static void permulate(int index, int n, int count, int m,int[] per) {
		if(count == m) {
			for(int number: per) {
				sb.append(number + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=index;i<=n;++i) {
			per[count] = i;
			permulate(i, n, count+1, m,per);
		}
	}

}
