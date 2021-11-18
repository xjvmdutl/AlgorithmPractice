package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
	public static int answer;
	public static int[] per;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		answer = 0;
		per = new int[n];
		dfs(0,n);
		return answer;
	}

	private static void dfs(int index, int n) {
		if(index == n) {
			answer++;
			return;
		}
		for(int i=0;i<n;++i) {
			per[index] = i;
			if(isOkay(index)) {
				dfs(index+1, n);
			}
		}
	}

	private static boolean isOkay(int index) {
		for(int i=0;i<index;++i) {
			if(per[index] == per[i]) {//같은 행이면 안된다
				return false;
			}else if(Math.abs(index - i) == Math.abs(per[index] - per[i])) {
				return false;
			}
		}
		return true;
	}

}
