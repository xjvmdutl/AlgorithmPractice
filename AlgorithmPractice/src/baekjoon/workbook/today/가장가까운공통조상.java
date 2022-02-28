package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 가장가까운공통조상 {
	public static boolean[] visit;
	public static int[] parents;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			parents = new int[n];
			Arrays.fill(parents, -1);
			for(int i=0;i<n-1;++i) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokens.nextToken())- 1;
				int end = Integer.parseInt(tokens.nextToken())- 1;
				parents[end] = start;
			}
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n1 = Integer.parseInt(tokens.nextToken()) - 1;
			int n2 = Integer.parseInt(tokens.nextToken()) - 1;
			System.out.println(solution(n1, n2, n));
		}
	}

	private static int solution(int n1, int n2, int n) {
		answer = 0;
		visit = new boolean[n];
		findFirst(n1, n);
		findSecond(n2);
		return answer + 1;
	}

	private static void findSecond(int now) {
		if(visit[now]) {
			answer = now;
			return;
		}
		findSecond(parents[now]);
	}

	private static void findFirst(int now, int n) {
		visit[now] = true;
		if(parents[now] == -1) {
			return;
		}
		findFirst(parents[now], n);
		
	}
}
