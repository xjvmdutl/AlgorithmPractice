package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N??M2 {
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

	private static void permulate(int index, int n, int cnt, int m, int[] per) {
		if(cnt == m) {
			for(int number : per) {
				sb.append(number + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=index;i<=n;++i) {
			per[cnt] = i;
			permulate(i+1, n, cnt+1, m, per);
		}
	}

}
