package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¼Ò¼ö {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(reader.readLine());
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(m,n));
	}

	private static String solution(int m, int n) {
		StringBuilder sb = new StringBuilder();
		boolean[] sosu = new boolean[n+1];
		sosu[1] = true;
		for(int i=2;i<=n;++i) {
			for(int j=i*i;j<=n;j+=i) {
				sosu[j] = true;
			}
		}
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i=m;i<=n;++i)
			if(!sosu[i]) {
				min = Math.min(min, i);
				sum += i;
			}
		if(min != Integer.MAX_VALUE)
			sb.append(sum+"\n"+min);
		else
			sb.append("-1");
		return sb.toString();
	}

}
