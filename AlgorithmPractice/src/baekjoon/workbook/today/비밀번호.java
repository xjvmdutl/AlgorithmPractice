package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 비밀번호 {
	public static int answer;
	public static boolean[] visit;
	public static StringBuilder per;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[] arr = null;
		if(m > 0) {
			arr = new int[m];
			tokens = new StringTokenizer(reader.readLine());
			for(int i=0;i<m;++i) {
				arr[i] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr, n, m ));
	}

	private static int solution(int[] arr, int n, int m) {
		answer = 0;
		visit = new boolean[10];
		for(int i=0;i<m;++i) {
			visit[arr[i]] = true;
		}
		permulate(0, 0, n, m);
		
		return answer ;
	}

	private static void permulate(int count, int mCount, int n, int m) {
		if(n == count) {
			if(mCount == m)
				answer++;
			return;
		}
		for(int i=0;i<=9;++i) {
			if(visit[i]) {
				visit[i] = false;
				permulate(count+1, mCount+1, n, m);
				visit[i] = true;
			}else {
				permulate(count+1, mCount, n, m);
			}
		}
	}

}
