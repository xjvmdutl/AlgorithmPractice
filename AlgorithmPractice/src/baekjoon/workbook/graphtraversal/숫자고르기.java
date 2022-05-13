package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 숫자고르기 {
	private static boolean[] visit;
	private static List<Integer> cycle;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[2][n];
		for(int i=0;i<n;++i) {
			map[0][i] = i;
			map[1][i] = Integer.parseInt(reader.readLine()) - 1;
		}
		System.out.println(solution(map, n));
	}

	private static String solution(int[][] map, int n) {
		visit = new boolean[n];
		cycle = new ArrayList<>();
		for(int i=0;i<n;++i) {
			visit[i] = true;
			dfs(map, i, i);
			visit[i] = false;
		}
		
		return getResult();
	}

	private static void dfs(int[][] map, int number, int target) {
		if(!visit[map[1][number]]) {
			visit[map[1][number]] = true;
			dfs(map, map[1][number], target);
			visit[map[1][number]] = false;
		}
		if(map[1][number] == map[0][target]) {
			cycle.add(map[0][number] + 1);
		}
	}
	private static String getResult() {
		StringBuilder answer = new StringBuilder();
		Collections.sort(cycle);
		answer.append(cycle.size() + "\n");
		for(int num : cycle) {
			answer.append(num + "\n");
		}
		return answer.toString();
	}


}
